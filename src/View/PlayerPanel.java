package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Player;
import Model.PlayerRoster;

public class PlayerPanel extends JPanel implements ActionListener {
    // Variable to track the readiness state
    boolean isReady = false;

    //components.
    JButton ReadyButton = new JButton("Ready");
    JButton SelectPlayerButton = new JButton("Select player");
    JLabel playerX = new JLabel("X");
    JLabel palyer0 = new JLabel("O");

    //Maps player names to their player objs.
    Map<String, Player> players;

    //The roster.
    PlayerRoster playerRoster;

    public PlayerPanel(String position, PlayerRoster pr){
        this.playerRoster=pr;
        setupPlayerPanel(position);
    }

    private void setupPlayerPanel(String position){
        this.setName(position);
        this.setBackground(Color.green);
        setBoundsOfPanel(position);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 110));

        //this.SelectPlayerButton.addActionListener(this);
        //this.ReadyButton.addActionListener(this);

        this.add(ReadyButton);
        this.add(SelectPlayerButton);
    }

    private void setBoundsOfPanel(String position){
        if(position=="Left"){
            this.setBounds(0,0,300,800);
        }else if(position=="Right"){
            this.setBounds(900,0,300,800);
        }
    }

    public void selectPlayerFromRoaster(){
        JFrame playerRosterFrame = new JFrame();
        @SuppressWarnings("rawtypes")
        JComboBox availablePlayers = new JComboBox();
        JButton button = new JButton("Select");
        JLabel noteLabel = new JLabel("select a player...");

        availablePlayers.setSize(new Dimension(100, 100));

        putPlayersInsideComboBox(availablePlayers, playerRoster.findAllPlayersNames());

        playerRosterFrame.setTitle("Select "+ this.getName() + " player.");
        playerRosterFrame.setResizable(false);
        playerRosterFrame.setSize(300, 120);
        playerRosterFrame.setLayout(new FlowLayout());

        playerRosterFrame.add(noteLabel);
        playerRosterFrame.add(availablePlayers);
        playerRosterFrame.add(button);

        playerRosterFrame.setVisible(true);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void putPlayersInsideComboBox(JComboBox box, String[] players){
        for(int i=0; i<players.length; i++){
            box.addItem(players[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.SelectPlayerButton){
            selectPlayerFromRoaster();
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

    //Setters, getters.
    public PlayerRoster getPlayerRoster() {
        return playerRoster;
    }

    public void setPlayerRoster(PlayerRoster playerRoster) {
        this.playerRoster = playerRoster;
    }
}