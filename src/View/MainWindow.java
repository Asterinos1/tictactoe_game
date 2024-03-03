package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import Model.*;

public class MainWindow extends JFrame {
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