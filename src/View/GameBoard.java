package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements ActionListener{ 
    
    private static final int NUM_OF_BUTTONS = 9;
    private JButton[] buttons;

    public GameBoard() {
        this.setBackground(Color.CYAN);
        this.setBounds(300, 100, 600, 700);
        this.setLayout(new GridLayout(3, 3, 5, 5));
        this.initializeButtons();
        this.setVisible(true);
    }

    private void initializeButtons() {
        buttons = new JButton[NUM_OF_BUTTONS];
        for (int i = 0; i < NUM_OF_BUTTONS; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setEnabled(true);
            this.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.buttons) {

        }
    }

    public void modifyButtons(JButton button){
        button.setEnabled(false);
    }
}
