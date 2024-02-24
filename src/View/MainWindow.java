package View;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
    
    public MainWindow(){

        this.setTitle("Tic-Tac-Toe");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setLayout(null);
        this.add(new BannerPanel());
        this.add(new PlayerPanel("Left"));
        this.add(new PlayerPanel("Right"));
        this.setVisible(true);

        //setting a image on the top left of the frame.
        ImageIcon image = new ImageIcon("ttt.png");
        this.setIconImage(image.getImage());
        //set frame background colour.
        this.getContentPane().setBackground(new Color(255,251,182));

    }
}
