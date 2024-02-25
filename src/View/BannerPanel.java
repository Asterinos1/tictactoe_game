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

public class BannerPanel extends JPanel implements ActionListener{
    ViewActions va = new ViewActions();
    JButton addPlayerButton = new JButton("Add player");
    JButton HOFButton = new JButton("Hall of fame");
    JButton QuitButton = new JButton("Quit");

    public BannerPanel(){
        this.setBackground(Color.orange);
        this.setBounds(0, 0, 1200, 100);
        this.setLayout(null);
        setupButtons();
        this.add(this.addPlayerButton);
        this.add(this.HOFButton);
        this.add(this.QuitButton);
    }
    //Setting up buttons on the banner panel manually.
    private void setupButtons(){
        this.addPlayerButton.setBounds(50, 20, 300,60);
        this.HOFButton.setBounds(450,20,300,60);
        this.QuitButton.setBounds(850, 20,300,60);
    
        this.addPlayerButton.setFocusable(false);
        this.HOFButton.setFocusable(false);
        this.QuitButton.setFocusable(false);
        
        this.QuitButton.addActionListener(this);
        this.addPlayerButton.addActionListener(this);
    }

    public void addPlayerToRoaster(){
        JFrame apframe = new JFrame("Add player");
        JTextField textField = new JTextField();
        JButton button = new JButton("Add");
        JLabel noteLabel = new JLabel("Please enter the new player's name.");

        textField.setPreferredSize(new Dimension(250, 20));

        button.addActionListener(null);

        apframe.setResizable(false);
        apframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            this.va.quitButtonAction();
        }
        if(e.getSource()==this.addPlayerButton){
            addPlayerToRoaster();
        }
    }
}
