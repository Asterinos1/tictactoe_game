package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    String position;

    //components.
    JButton ReadyButton = new JButton("Ready");
    JButton SelectPlayerButton = new JButton("Select player");
    //Player name.
    JLabel playerNameLabel = new JLabel(" ");
    //Player stats.
    JLabel playerStatsLabel = new JLabel("Total Wins: 0 | Total Losses: 0 | Total Draws: 0 | Score: 0");


    //The roster.
    PlayerRoster playerRoster;

    public PlayerPanel(String position, PlayerRoster pr){
        this.playerRoster=pr;
        this.position=position;
        setupPlayerPanel(position);

    }

    private void setupPlayerPanel(String position) {
        this.setName(position);
        this.setBackground(Color.green);
        setBoundsOfPanel(position);
    
        // Set GridBagLayout manager
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);
    
        // Set constraints for ReadyButton
        constraints.gridx = 0; // Column 0
        constraints.gridy = 0; // Row 0
        constraints.insets = new Insets(0, 0, 10, 0); // Bottom margin
        constraints.anchor = GridBagConstraints.CENTER; // Center horizontally
        this.add(ReadyButton, constraints);
    
        // Set constraints for SelectPlayerButton
        constraints.gridy = 1; // Row 1
        this.add(SelectPlayerButton, constraints);
    
        // Set constraints for playerName label
        constraints.gridy = 2; // Row 2
        constraints.insets = new Insets(10, 0, 0, 0); // Top margin
        this.add(playerNameLabel, constraints);
    
        // Add labels for player stats vertically
        constraints.gridy = 3; // Start from Row 3
        constraints.insets = new Insets(10, 0, 0, 0); // Top margin
    
        JLabel totalVictoriesLabel = new JLabel("Total Victories: ");
        this.add(totalVictoriesLabel, constraints);
    
        constraints.gridy++;
        JLabel totalDefeatsLabel = new JLabel("Total Defeats: ");
        this.add(totalDefeatsLabel, constraints);
    
        constraints.gridy++;
        JLabel totalDrawsLabel = new JLabel("Total Draws: ");
        this.add(totalDrawsLabel, constraints);
    
        constraints.gridy++;
        JLabel playerScoreLabel = new JLabel("Player Score: ");
        this.add(playerScoreLabel, constraints);
    
        // Make buttons non-focusable
        this.ReadyButton.setFocusable(false);
        this.SelectPlayerButton.setFocusable(false);
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

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item from the JComboBox
                String selectedPlayerName = (String) availablePlayers.getSelectedItem();
                if (selectedPlayerName != null) {
                    // Get the selected player from the player roster
                    Player selectedPlayer = playerRoster.findPlayerByName(selectedPlayerName);
                    if (selectedPlayer != null) {
                        // Update player name label
                        playerNameLabel.setText(selectedPlayer.getName());
                        // Update player stats label
                        playerStatsLabel.setText("Total Wins: " + selectedPlayer.getNumOfVictories() +
                                " | Total Losses: " + selectedPlayer.getNumOfDefeats() +
                                " | Total Draws: " + selectedPlayer.getNumOfDraws() +
                                " | Score: " + selectedPlayer.getScore());
                    }
                }
            }
        });

    }

    public void setPlayerName(String name){
        this.playerNameLabel.setText(name);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void putPlayersInsideComboBox(JComboBox box, String[] players){
        for(int i=0; i<players.length; i++){
            box.addItem(players[i]);
        }
    }

    /* */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.SelectPlayerButton){
            selectPlayerFromRoaster();
        } 

        if (e.getSource() == this.ReadyButton) {
            // Toggle readiness state
            isReady = !isReady;

            // Change button color based on readiness state
            if (!isReady) {
                ReadyButton.setBackground(Color.GRAY);
                System.out.println(position + " is ready.");
            } else {
                ReadyButton.setBackground(Color.WHITE); // Reset to default color
                System.out.println(position + " not ready.");
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