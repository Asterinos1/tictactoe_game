package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Player;

public class PlayerPanel extends JPanel implements ActionListener {
    // Variable to track the readiness state
    boolean isReady = false;

    //components.
    JButton ReadyButton = new JButton("Ready");
    JButton SelectPlayerButton = new JButton("Select player");
    JLabel playerX = new JLabel("X");
    JLabel palyer0 = new JLabel("O");

    Map<String, Player> players;

    public PlayerPanel(String position){
        this.setName(position);
        this.setBackground(Color.green);
        setBoundsOfPanel(position);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 110));

        this.SelectPlayerButton.addActionListener(this);
        this.ReadyButton.addActionListener(this);

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
        @SuppressWarnings("rawtypes")
        JComboBox availablePlayers = new JComboBox();
        JButton button = new JButton("Select");
        JLabel noteLabel = new JLabel("select a player...");

        availablePlayers.setSize(new Dimension(100, 100));

        //putPlayersInsideComboBox(availablePlayers, playerList.getPlayers());

        playerRoaster.setTitle("Select "+ this.getName() + " player.");
        playerRoaster.setResizable(false);
        playerRoaster.setSize(300, 120);
        playerRoaster.setLayout(new FlowLayout());

        playerRoaster.add(noteLabel);
        playerRoaster.add(availablePlayers);
        playerRoaster.add(button);

        playerRoaster.setVisible(true);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void putPlayersInsideComboBox(JComboBox box, ArrayList<Player> players){
        for(int i=0; i<players.size(); i++){
            box.addItem(players.get(i).getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.SelectPlayerButton){
            System.err.println("Hello player");
        } 

        if (e.getSource() == this.ReadyButton) {
            // Toggle readiness state
            isReady = !isReady;

            // Change button color based on readiness state
            if (isReady) {
                ReadyButton.setBackground(Color.GRAY);
                System.out.println(this.getName() + " is ready.");
            } else {
                ReadyButton.setBackground(Color.WHITE); // Reset to default color
                System.out.println(this.getName() + " not ready.");
            }
        }
    }
}
