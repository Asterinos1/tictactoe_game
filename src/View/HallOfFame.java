package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Player;
import Model.PlayerRoster;

public class HallOfFame extends JPanel {
    private JLabel ScreenTitle = new JLabel("Hall of fame");
    private PlayerRoster playerRoster;
    private JPanel playerListPanel;
    
    public HallOfFame(PlayerRoster pr){
        this.playerRoster=pr;
        setupHallOfFame();
    }

    private void setupHallOfFame() {
        this.setBackground(Color.white);
        this.setBounds(300, 100, 600, 700);
        this.add(ScreenTitle);
    }

    public void updatePlayerRoster(PlayerRoster pr){
        this.playerRoster=pr;
    }

    private void updatePlayerList() {
        List<Player> topPlayers = playerRoster.findHallOfFame();
        if (playerListPanel != null) {
            remove(playerListPanel); // Clear previous player list
        }
        playerListPanel = new JPanel(new GridLayout(topPlayers.size(), 1)); // Vertical layout for player names
        for (Player player : topPlayers) {
            JLabel playerNameLabel = new JLabel(player.getName());
            playerListPanel.add(playerNameLabel);
        }
        add(playerListPanel);
        revalidate(); // Refresh the layout
        repaint(); // Repaint the panel
    }
}
