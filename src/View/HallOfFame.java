package View;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.PlayerRoster;

public class HallOfFame extends JPanel {
    private JLabel ScreenTitle = new JLabel("Hall of fame");
    private PlayerRoster playerRoster;
    
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
}
