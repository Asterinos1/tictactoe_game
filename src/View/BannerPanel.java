package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.PlayerRoster;

public class BannerPanel extends JPanel implements ActionListener{

    PlayerRoster pr;

    ViewActions va = new ViewActions();
    JButton addPlayerButton = new JButton("Add player");
    JButton HOFButton = new JButton("Hall of fame");
    JButton QuitButton = new JButton("Quit");

    //Alt-constructor.
    public BannerPanel(PlayerRoster pr){
        this.pr=pr;
        setupBannerPanel();
    }

    private void setupBannerPanel(){
        this.setBackground(Color.orange);
        this.setBounds(0, 0, 1200, 100);
        this.setLayout(null);
        this.addPlayerButton.setBounds(50, 20, 300,60);
        this.HOFButton.setBounds(450,20,300,60);
        this.QuitButton.setBounds(850, 20,300,60);
    
        this.addPlayerButton.setFocusable(false);
        this.HOFButton.setFocusable(false);
        this.QuitButton.setFocusable(false);
        
        this.QuitButton.addActionListener(this);
        this.addPlayerButton.addActionListener(this);
        this.add(this.addPlayerButton);
        this.add(this.HOFButton);
        this.add(this.QuitButton);
    }


    public void addPlayerToRoaster(){
        JFrame apframe = new JFrame("Add player");
        JTextField textField = new JTextField();
        JButton button = new JButton("Add");
        JLabel noteLabel = new JLabel("Please enter the new player's name.");

        textField.setPreferredSize(new Dimension(250, 20));

        button.addActionListener(null);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = textField.getText();
                pr.addNewPlayer(playerName); // Call addNewPlayer method here
                apframe.dispose(); // Close the frame after adding the player
            }
        });

        apframe.setResizable(false);
        apframe.setSize(300, 120);
        apframe.setLayout(new FlowLayout());
        
        apframe.add(noteLabel);
        apframe.add(textField);
        apframe.add(button);

        apframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.QuitButton){
            ViewActions.quitButtonAction();
        }
        if(e.getSource()==this.addPlayerButton){
            addPlayerToRoaster();
        }
    }
}
