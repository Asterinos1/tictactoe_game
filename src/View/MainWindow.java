package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import Model.*;

public class MainWindow extends JFrame {
    
    Board board = new Board();
    PlayerRoster pr = new PlayerRoster();

    private HallOfFame hof;
    private BannerPanel bp;
    private GameBoard gb;
    private PlayerPanel lpp;
    private PlayerPanel rpp;

    public MainWindow(Board board, PlayerRoster pr){
        this.board = board;
        this.pr=pr;

        setupMainWindow();

        //set frame background colour.
        this.getContentPane().setBackground(new Color(255,251,182));

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

    public void setupMainWindow(){
        this.setTitle("Tic-Tac-Toe");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLayout(null);

        this.hof = new HallOfFame();
        this.bp = new BannerPanel(this.pr);
        this.gb = new GameBoard();
        this.lpp = new PlayerPanel("Left");
        this.rpp = new PlayerPanel("Right");

        this.add(this.bp);
        this.add(this.lpp);
        this.add(this.rpp);

        this.hof.setVisible(false);
        this.add(this.hof);
        this.add(this.gb);

        this.setVisible(true);
    }
}