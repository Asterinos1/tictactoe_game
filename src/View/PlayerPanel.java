package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerPanel extends JPanel implements ActionListener {

    JButton ReadyButton = new JButton("Ready");
    JButton SelectPlayerButton = new JButton("Select player");
    JLabel playerX = new JLabel("X");
    JLabel palyer0 = new JLabel("O");

    public PlayerPanel(String position){
        this.setBackground(Color.green);
        setBoundsOfPanel(position);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 110));

        this.SelectPlayerButton.addActionListener(this);
        this.add(ReadyButton);
        this.add(SelectPlayerButton);
    }

    public void setBoundsOfPanel(String position){
        if(position=="Left"){
            this.setBounds(0,0,300,800);
        }else if(position=="Right"){
            this.setBounds(900,0,300,800);
        }
    }
    
    public void setupButtons(){
        this.ReadyButton.setBounds(10, 110, 240, 50);
        this.SelectPlayerButton.setBounds(10, 170, 240, 50);
    }

    public void selectPlayerFromRoaster(){
        JFrame playerRoaster = new JFrame();

        playerRoaster.setTitle("Select player.");
        playerRoaster.setResizable(false);
        playerRoaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerRoaster.setSize(200, 200);
        playerRoaster.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.SelectPlayerButton){
            selectPlayerFromRoaster();
        }
    }
}
