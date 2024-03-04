package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import Model.*;

public class MainWindow extends JFrame implements ActionListener{
    Board board;
    PlayerRoster playerRoster;

    private HallOfFame hof;
    private BannerPanel bp;
    private GameBoard gb;
    private PlayerPanel lpp;
    private PlayerPanel rpp;
    
    public MainWindow(){
        this.board = new Board();
        this.playerRoster= new PlayerRoster();
        setupMainWindow();

        //new
        enableButtonFunctionality();

        
        // Add action listener to the "Hall of Fame" button in BannerPanel
        bp.HOFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle visibility of HallOfFame and GameBoard panels
                hof.setVisible(!hof.isVisible());
                gb.setVisible(!hof.isVisible());
            }
        });
    }

    public void gameLogic(){
        //In this function the game is to be implemented.

        //Example:
        //this.hof.updatePlayerRoster();

        //actionsListerns to be added to the buttons through here.
        //this.hof.PlayerButton.addActionListerner(this.)

        //Just use this class to run everything.
    }

    //Setup window settings, attach panels and set dimenions.
    public void setupMainWindow(){
        this.setTitle("Tic-Tac-Toe");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLayout(null);

        this.hof = new HallOfFame(getPlayerRoster());
        this.bp = new BannerPanel(getPlayerRoster());
        this.gb = new GameBoard(getBoard(), getPlayerRoster());
        this.lpp = new PlayerPanel("Left", getPlayerRoster());
        this.rpp = new PlayerPanel("Right", getPlayerRoster());

        this.add(this.bp);
        this.add(this.lpp);
        this.add(this.rpp);

        this.hof.setVisible(false);
        this.add(this.hof);
        this.add(this.gb);

        this.setVisible(true);

        this.getContentPane().setBackground(new Color(255,251,182));
    }

    public void enableButtonFunctionality(){
        //Banner Panel.
        this.bp.HOFButton.addActionListener(this);
        this.bp.QuitButton.addActionListener(this);
        this.bp.addPlayerButton.addActionListener(this);

        //PlayerPanels.
        //Left
        this.lpp.ReadyButton.addActionListener(this);
        this.lpp.SelectPlayerButton.addActionListener(this);
        //Right
        this.rpp.ReadyButton.addActionListener(this);
        this.rpp.SelectPlayerButton.addActionListener(this);

        //GameBoard.
        for(int i=0; i<GameBoard.NUM_OF_BUTTONS; i++){
            this.gb.buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BannerPanel.
        if(e.getSource()==this.bp.QuitButton){
            ViewActions.quitButtonAction();
        }
        if(e.getSource()==this.bp.addPlayerButton){
            bp.addPlayerToRoaster();
            gb.setPr(bp.getPlayerRoster());
            hof.updatePlayerRoster(bp.getPlayerRoster());
            lpp.setPlayerRoster(bp.getPlayerRoster());
            rpp.setPlayerRoster(bp.getPlayerRoster());
        }

        //====================================================================================//

        // PlayerPanel

        //Left.
        if (e.getSource() == this.lpp.SelectPlayerButton) {
            this.lpp.selectPlayerFromRoaster();
        }

        if (e.getSource() == this.lpp.ReadyButton) {
            // Toggle readiness state
            this.lpp.isReady = !(this.lpp.isReady);

            // Change button color based on readiness state
            if (this.lpp.isReady) {
                this.lpp.ReadyButton.setBackground(Color.GRAY);
                System.out.println(this.lpp.position + " is ready.");
            } else {
                this.lpp.ReadyButton.setBackground(Color.WHITE); // Reset to default color
                System.out.println(this.lpp.position + " not ready.");
            }
        }

        //Right.
        if (e.getSource() == this.rpp.SelectPlayerButton) {
            this.rpp.selectPlayerFromRoaster();
        }

        if (e.getSource() == this.rpp.ReadyButton) {
            // Toggle readiness state
            this.rpp.isReady = !(this.rpp.isReady);

            // Change button color based on readiness state
            if (this.rpp.isReady) {
                this.rpp.ReadyButton.setBackground(Color.GRAY);
                System.out.println(this.rpp.position + " is ready.");
            } else {
                this.rpp.ReadyButton.setBackground(Color.WHITE); // Reset to default color
                System.out.println(this.rpp.position + " not ready.");
            }
        }

        // Check if both players are ready
        if (this.lpp.isReady && this.rpp.isReady) {
            System.out.println("Both ready.");
            // Enable buttons in GameBoard
            for (JButton button : this.gb.buttons) {
                button.setEnabled(true);
            }
            this.bp.HOFButton.setEnabled(false);

            this.lpp.SelectPlayerButton.setEnabled(false);
            this.rpp.SelectPlayerButton.setEnabled(false);
        } else {
            // Disable buttons in GameBoard
            for (JButton button : this.gb.buttons) {
                button.setEnabled(false);
            }
        }
        //end of player panel.

        //====================================================================================//

        //GameBoard.
        for (int i = 0; i < GameBoard.NUM_OF_BUTTONS; i++) {
            if (e.getSource() == this.gb.buttons[i]) {
                
                int row = i/3;
                int col = i%3;

                System.out.println("Button pressed: " +  this.gb.buttons[i].getText() + " that is :"+ row + ", "+ col);

                board.makeMove2(row, col);

                // Update the button text based on the state of the corresponding position on the board
                if (board.getBoard()[row][col] == 'X') {
                    this.gb.turnLabel.setText("O's turn.");
                    this.gb.buttons[i].setText("X");
                    this.gb.buttons[i].setForeground(Color.RED);
                } else if (board.getBoard()[row][col] == 'O') {
                    this.gb.turnLabel.setText("X's turn.");
                    this.gb.buttons[i].setText("O");
                    this.gb.buttons[i].setForeground(Color.BLUE);   
                }
 
                // Disable the button after setting the text
                this.gb.buttons[i].setEnabled(false);
                
                 // Check if the game has finished
                if (board.isGameFinished()) {

                    if(board.getWinner()==0){
                        this.gb.turnLabel.setText("Game is a Tie.");
                    }else if(board.getWinner()==1){
                        this.gb.turnLabel.setText("X winner.");
                    }else if(board.getWinner()==2){
                        this.gb.turnLabel.setText("O winner.");
                    }

                        
                    // If the game has finished, disable all buttons
                    for (JButton button : this.gb.buttons) {
                        button.setEnabled(false);
                    }
                    
                    //Reseting board.
                    gb.resetBoard();

                    //Reset ready buttons.
                    this.rpp.isReady = false;
                    this.lpp.isReady = false;

                    this.rpp.ReadyButton.setBackground(Color.WHITE);
                    this.lpp.ReadyButton.setBackground(Color.WHITE);

                    //Reset select buttons.
                    this.lpp.SelectPlayerButton.setEnabled(true);
                    this.rpp.SelectPlayerButton.setEnabled(true);

                    //Reset HOF Button.
                    this.bp.HOFButton.setEnabled(true);

                    for (JButton button : this.gb.buttons) {
                        button.setEnabled(false);
                    }
                }
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public PlayerRoster getPlayerRoster() {
        return playerRoster;
    }

    public void setPlayerRoster(PlayerRoster pr) {
        this.playerRoster = pr;
    }
}