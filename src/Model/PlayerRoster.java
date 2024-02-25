package Model;

import java.io.File;
import java.util.ArrayList;

public class PlayerRoster{
    ArrayList<Player> players = new ArrayList<Player>();

    public PlayerRoster(){
        //creating some dummy players...
        this.players.add(new Player("John"));
        this.players.add(new Player("George"));
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void loadPlayers() {
        File file = new File("playerroster.txt");
        
        if(file.exists()) {
            System.out.println("I found it!");
        }else{
            System.out.println("Can't see the file");
        }
    }
}