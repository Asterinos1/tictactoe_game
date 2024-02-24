package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BannerPanel extends JPanel implements ActionListener{
    
    JButton StartButton = new JButton("Start");
    JButton HOFButton = new JButton("Hall of fame");
    JButton QuitButton = new JButton("Quit");
    
    private void setupButtons(){
        this.StartButton.setBounds(50, 20, 300,60);
        this.HOFButton.setBounds(450,20,300,60);
        this.QuitButton.setBounds(850, 20,300,60);
    
        this.StartButton.setFocusable(false);
        this.HOFButton.setFocusable(false);
        this.QuitButton.setFocusable(false);
        
        this.QuitButton.addActionListener(this);
    }

    public BannerPanel(){
        this.setBackground(Color.orange);
        this.setBounds(0, 0, 1200, 100);
        this.setLayout(null);
        setupButtons();
        this.add(this.StartButton);
        this.add(this.HOFButton);
        this.add(this.QuitButton);
    }

    public void startButtonAction(){

    }

    public void HOFButtonAction(){

    }

    public void quitButtonAction(ActionEvent e){
        if(e.getSource()==this.QuitButton){
            System.exit(0);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.QuitButton){
            System.exit(0);
        }
    }


}
