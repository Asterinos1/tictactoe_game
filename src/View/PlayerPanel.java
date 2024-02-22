package View;

import java.awt.Color;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel{

    public PlayerPanel(String position){
        this.setBackground(Color.green);
        setBoundsOfPanel(position);
    }

    public void setBoundsOfPanel(String position){
        if(position=="Left"){
            this.setBounds(0,0,300,800);
        }else if(position=="Right"){
            this.setBounds(900,0,300,800);
        }
    }
}
