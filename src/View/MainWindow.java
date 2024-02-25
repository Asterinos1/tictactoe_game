package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
}
