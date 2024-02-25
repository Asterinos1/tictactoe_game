package View;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
    HallOfFame hof = new HallOfFame();
    PlayerPanel lpp = new PlayerPanel("Left");
    PlayerPanel rpp = new PlayerPanel("Right");
    BannerPanel bp = new BannerPanel();
    GameBoard gb = new GameBoard();


    public MainWindow(){
        this.setTitle("Tic-Tac-Toe");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLayout(null);
        this.add(bp);
        this.add(lpp);
        this.add(rpp);
        this.hof.setVisible(false);
        this.add(hof);
        this.add(gb);
        this.setVisible(true);

        //setting a image on the top left of the frame.
        ImageIcon image = new ImageIcon("ttt.png");
        this.setIconImage(image.getImage());
        //set frame background colour.
        this.getContentPane().setBackground(new Color(255,251,182));

    }
}
