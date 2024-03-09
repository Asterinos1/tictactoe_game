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
        enableButtonFunctionality();
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
        //Hall of fame.
        if(e.getSource()==this.bp.HOFButton){
            hof.setVisible(!hof.isVisible());
            gb.setVisible(!hof.isVisible());
    
            if(lpp.ReadyButton.isEnabled() && rpp.ReadyButton.isEnabled()){
                // Disable Ready buttons when Hall of Fame button is pressed
                lpp.ReadyButton.setEnabled(false);
                rpp.ReadyButton.setEnabled(false);
            }else if(!lpp.ReadyButton.isEnabled() && !rpp.ReadyButton.isEnabled()){
                //Enable the buttons.
                lpp.ReadyButton.setEnabled(true);
                rpp.ReadyButton.setEnabled(true);
            }
        }
        //===================================================================================//
        //BannerPanel.
        if(e.getSource()==this.bp.QuitButton){
            System.exit(0);
        }
        if(e.getSource()==this.bp.addPlayerButton){
            bp.addPlayerToRoaster();
            playerRoster=bp.getPlayerRoster();
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
            if(this.lpp.getPlayerNameHere()==" "){
                System.out.println("Select a player.");
            }else{
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
        }

        //Right.
        if (e.getSource() == this.rpp.SelectPlayerButton) {
            this.rpp.selectPlayerFromRoaster();
        }

        if (e.getSource() == this.rpp.ReadyButton) {

            if(this.rpp.getPlayerNameHere()==" "){
                System.out.println("Select a player first.");                
            }else{
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
        }

        // Check if both players are ready
        if (this.lpp.isReady && this.rpp.isReady) {
            //System.out.println("The game can start.");
            // Enable buttons in GameBoard
            for (JButton button : this.gb.buttons) {
                button.setEnabled(true);
            }
            this.bp.HOFButton.setEnabled(false);

            this.lpp.SelectPlayerButton.setEnabled(false);
            this.rpp.SelectPlayerButton.setEnabled(false);
            this.lpp.ReadyButton.setEnabled(false);
            this.lpp.ReadyButton.setEnabled(false);
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

                board.makeMove(row, col);

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

                    playerRoster.createNewGamerecord(this.lpp.getPlayerNameHere(),this.rpp.getPlayerNameHere(),board.getWinner());

                    this.hof.updatePlayerRoster(playerRoster);
                    this.bp.setPlayerRoster(playerRoster);
                    this.rpp.setPlayerRoster(playerRoster);
                    this.lpp.setPlayerRoster(playerRoster);
                        
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

                    //Reset ready buttons.
                    this.lpp.ReadyButton.setEnabled(true);
                    this.rpp.ReadyButton.setEnabled(true);

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