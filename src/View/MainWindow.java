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
        this.lpp.ReadyButton.addActionListener(this);

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
        }

        //PlayerPanels.
        //Left.
        if(e.getSource() == this.lpp.SelectPlayerButton){
            this.lpp.selectPlayerFromRoaster();
        } 

        if (e.getSource() == this.lpp.ReadyButton) {
            // Toggle readiness state
            this.lpp.isReady = !(this.lpp.isReady);

            // Change button color based on readiness state
            if (this.lpp.isReady) {
                this.lpp.ReadyButton.setBackground(Color.GRAY);
                System.out.println(this.getName() + " is ready.");
            } else {
                this.lpp.ReadyButton.setBackground(Color.WHITE); // Reset to default color
                System.out.println(this.getName() + " not ready.");
            }
        }
        //Right.
        if(e.getSource() == this.rpp.SelectPlayerButton){
            this.rpp.selectPlayerFromRoaster();
        } 

        if (e.getSource() == this.rpp.ReadyButton) {
            // Toggle readiness state
            this.rpp.isReady = !(this.rpp.isReady);

            // Change button color based on readiness state
            if (this.rpp.isReady) {
                this.rpp.ReadyButton.setBackground(Color.GRAY);
                System.out.println(this.getName() + " is ready.");
            } else {
                this.rpp.ReadyButton.setBackground(Color.WHITE); // Reset to default color
                System.out.println(this.getName() + " not ready.");
            }
        }
        //end of player panel.

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
                    this.gb.buttons[i].setForeground(Color.RED);
                    this.gb.buttons[i].setText("X");
                } else if (board.getBoard()[row][col] == 'O') {
                    this.gb.turnLabel.setText("X's turn.");
                    this.gb.buttons[i].setForeground(Color.BLUE);
                    this.gb.buttons[i].setText("O");
                }
 
                // Disable the button after setting the text
                this.gb.buttons[i].setEnabled(false);
                
                 // Check if the game has finished
                if (board.gameHasFinished()) {

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

                    //gb.resetBoard();

                    for (JButton button : this.gb.buttons) {
                        button.setEnabled(true);
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