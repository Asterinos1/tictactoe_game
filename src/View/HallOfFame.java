package View;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Player;
import Model.PlayerRoster;

public class HallOfFame extends JPanel {
    private JLabel screenTitle = new JLabel("Hall of Fame");
    private PlayerRoster playerRoster;
    private JPanel playerListPanel;

    public HallOfFame(PlayerRoster pr) {
        this.playerRoster = pr;
        setupHallOfFame();
    }

    private void setupHallOfFame() {
        this.setBackground(Color.WHITE);
        this.setBounds(300, 100, 600, 700);
        this.screenTitle.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(screenTitle);

        playerListPanel = new JPanel();
        playerListPanel.setBackground(Color.WHITE);
        playerListPanel.setLayout(new BoxLayout(playerListPanel, BoxLayout.Y_AXIS)); // Vertical layout for player names and scores
        this.add(playerListPanel);

        displayPlayers(); // Display players immediately
    }

    private void displayPlayers() {
        List<Player> players = playerRoster.findHallOfFame(); // Get list of players from PlayerRoster
        int index = 1;
        for (Player player : players) {
            JLabel playerLabel = new JLabel(index + player.getName() + " - Score: " + player.getScore());
            playerLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Set a larger font size, you can adjust the font and size as needed
            playerListPanel.add(playerLabel);
            index++;
        }
    }

    public void updatePlayerRoster(PlayerRoster pr) {
        this.playerRoster = pr;
        playerListPanel.removeAll(); // Clear previous players
        displayPlayers(); // Display updated list
    }
}