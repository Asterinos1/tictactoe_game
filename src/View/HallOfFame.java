package View;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HallOfFame extends JPanel {
    JLabel ScreenTitle = new JLabel("Hall of fame");
    
    public HallOfFame(){
        this.setBackground(Color.BLUE);
        this.setBounds(300, 100, 600, 700);
        this.add(ScreenTitle);
    }
}
