package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerRoster{
    private static final String GAMERECORDFILE = "gamerecord.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //Here we store a list of all the games ever played.
    private List<GameRecord> gameRecords;
    // Map to store players by their name
    private Map<String, Player> players; 

    public PlayerRoster(){
        gameRecords = new ArrayList<>();
        players = new HashMap<>();
    }

    public void lodDataFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(GAMERECORDFILE))) {

            String line;

            while ((line = br.readLine()) != null) {
                // Split the line into parts
                String[] parts = line.split(";");

                // Parse the parts into variables
                String name1 = parts[0];
                String name2 = parts[1];
                int outcome = Integer.parseInt(parts[2]);
                float playerScore1 = Float.parseFloat(parts[3]);
                float playerScore2 = Float.parseFloat(parts[4]);
                LocalDateTime dateTime = LocalDateTime.parse(parts[5], DATE_TIME_FORMATTER);
                
                String outcome1=" ";
                if(outcome == 0){
                    outcome1 = "Tie";
                }else  if(outcome == 1){
                    outcome1 = name1+"'s won";
                }else if(outcome==2){
                    outcome1 = name2+"'s won";
                }
             
                //Checking the data here.
                System.out.println("Name1: " + name1);
                System.out.println("Name2: " + name2);
                System.out.println("Outcome: " + outcome1);
                System.out.println("Player Score1: " + playerScore1);
                System.out.println("Player Score2: " + playerScore2);
                System.out.println("Date: " + dateTime.format(DATE_TIME_FORMATTER));
                System.out.println("\n");
                
                // Create a new GameRecord object and add it to the list.
                GameRecord gameRecord = new GameRecord(name1, name2, outcome, playerScore1, playerScore2, dateTime);
                gameRecords.add(gameRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sorting the records.
        //sortGameRecordsByDate();

        // Iterate through each game record
        for (GameRecord gameRecord : gameRecords) {
            // Extract player names from the game record
            String playerName1 = gameRecord.getPlayer1();
            String playerName2 = gameRecord.getPlayer2();
            int outcome = gameRecord.getOutcome();

            // Check if player objects already exist for the player names
            if (!players.containsKey(playerName1)) {
                // If player object doesn't exist, create a new player object and add it to the players map
                Player player1 = new Player(playerName1);     
                players.put(playerName1, player1);
            }

            if (!players.containsKey(playerName2)) {
                // If player object doesn't exist, create a new player object and add it to the players map
                Player player2 = new Player(playerName2);
                players.put(playerName2, player2);
            }

            //Adjust players stats here.
            Player player1 = players.get(playerName1);
            Player player2 = players.get(playerName2);

            if (outcome == 0) {
                // Tie
                player1.incrementDraws();
                player2.incrementDraws();

                player1.incrementTotalGamesPlayed();
                player2.incrementTotalGamesPlayed();

                player1.updateScore();
                player2.updateScore();
            } else if (outcome == 1) {
                // Player 1 victory
                player1.incrementVictories();
                player2.incrementDefeats();

                player1.incrementTotalGamesPlayed();
                player2.incrementTotalGamesPlayed();

                player1.updateScore();
                player2.updateScore();
            } else if (outcome == 2) {
                // Player 2 victory
                player1.incrementDefeats();
                player2.incrementVictories();

                player1.incrementTotalGamesPlayed();
                player2.incrementTotalGamesPlayed();
                
                player1.updateScore();
                player2.updateScore();
            }
        }
    }

    //For sorting our games by date.
    public void sortGameRecordsByDate() {
        // Create a custom comparator for GameRecord objects based on date
        Comparator<GameRecord> dateComparator = new Comparator<GameRecord>() {
            @Override
            public int compare(GameRecord g1, GameRecord g2) {
                return g1.getDate().compareTo(g2.getDate());
            }
        };

        // Sort the gameRecords list using the custom comparator
        Collections.sort(gameRecords, dateComparator);
    }

    //print all games played so far.
    public void printAllGames(){
        for(int i=0; i<gameRecords.size(); i++){
            System.out.println(gameRecords.get(i).getPlayer1()+" vs " +gameRecords.get(i).getPlayer2()+" at " +gameRecords.get(i).getDate());
        }
        System.out.println("\n");
    }

    //print the stast of every player.
    public void printAllPlayersStats() {
        for (Map.Entry<String, Player> entry : this.players.entrySet()) {
            String playerName = entry.getKey();
            Player player = entry.getValue();
            
            System.out.println("Player Name: " + playerName);
            System.out.println("Total Games Played: " + player.getTotalGamesPlayed());
            System.out.println("Number of Victories: " + player.getNumOfVictories());
            System.out.println("Number of Defeats: " + player.getNumOfDefeats());
            System.out.println("Number of Draws: " + player.getNumOfDraws());
            System.out.println("Total player score: " + player.getScore());
            System.out.println("------------------------------------------");
        }
    }

    //Method to add a new player to the roster.
    public void addNewPlayer(String name){
        if(!players.containsKey(name)  && name.length()<=20){
            Player player = new Player(name);
            players.put(name, player);
        }else{
            System.out.println("Name"+ name+" rejected");
        }   
    }

    //String player1, String player2, int oucome, float scr1, float scr2, LocalDateTime date
    public void createNewGamerecord(String  playerName1, String playerName2, int outcome){
        if (players.containsKey(playerName1) && players.containsKey(playerName2)) {
            // Retrieve the player object associated with the playerName
            Player player1 = players.get(playerName1);
            Player player2 = players.get(playerName2);
            // Access the player's score from the player object
            float player1Score = player1.getScore();
            float player2Score = player2.getScore();
             // Get the current LocalDateTime
            LocalDateTime currentDateTime = LocalDateTime.now();
            
            gameRecords.add(new GameRecord(playerName1, playerName2, outcome, player1Score, player2Score, currentDateTime));
        } else {
            // Player not found in the roster
            // or any other appropriate value or handle the case as needed
        }
    }
    
    public void printCurrentRoaster(){
        System.out.println("Current roster");
        for(Map.Entry<String, Player> entry : this.players.entrySet()){
            String playerName = entry.getKey();
            System.out.println(playerName);
        }
    }

    public void getTop5RecentGamesForPlayer(String playerName) {
        // Check if the player exists in the players map
        if (players.containsKey(playerName)) {
            Player player = players.get(playerName);
            
            // Retrieve the player's game records
            List<GameRecord> playerGameRecords = new ArrayList<>();
            for (GameRecord gameRecord : gameRecords) {
                if (gameRecord.getPlayer1().equals(playerName) || gameRecord.getPlayer2().equals(playerName)) {
                    playerGameRecords.add(gameRecord);
                }
            }
            
            // Sort the player's game records by date in descending order (most recent first)
            Collections.sort(playerGameRecords, new Comparator<GameRecord>() {
                @Override
                public int compare(GameRecord g1, GameRecord g2) {
                    return g2.getDate().compareTo(g1.getDate());
                }
            });
            
            // Retrieve the top 5 most recent game records for the player
            List<GameRecord> top5RecentGames = playerGameRecords.subList(0, Math.min(playerGameRecords.size(), 5));
            
            // Print the top 5 most recent game records for the player
            System.out.println("Top 5 Most Recent Games for Player: " + playerName);
            for (GameRecord gameRecord : top5RecentGames) {
                System.out.println(gameRecord.getPlayer1() + " vs " + gameRecord.getPlayer2() + " at " + gameRecord.getDate());
            }
            System.out.println("------------------------------------------");
        } else {
            System.out.println("Player not found in the roster.");
        }
    }
    
    public void getTop5GamesForPlayer(String playerName) {
        // Check if the player exists in the players map
        if (players.containsKey(playerName)) {
            Player player = players.get(playerName);

            // Retrieve the player's game records
            List<GameRecord> playerGameRecords = new ArrayList<>();
            for (GameRecord gameRecord : gameRecords) {
                if (gameRecord.getPlayer1().equals(playerName) || gameRecord.getPlayer2().equals(playerName)) {
                    playerGameRecords.add(gameRecord);
                }
            }

            // Sort the player's game records using custom comparator
            Collections.sort(playerGameRecords, new Comparator<GameRecord>() {
                @Override
                public int compare(GameRecord g1, GameRecord g2) {
                    // Compare based on outcome (win > draw > lose)
                    if (g1.getOutcome() != g2.getOutcome()) {
                        return Integer.compare(g2.getOutcome(), g1.getOutcome());
                    }
                    
                    // If outcome is same, compare based on player score at the time the game record was created
                    float score1 = players.get(g1.getPlayer1()).getScore() + players.get(g1.getPlayer2()).getScore();
                    float score2 = players.get(g2.getPlayer1()).getScore() + players.get(g2.getPlayer2()).getScore();
                    
                    if (Float.compare(score1, score2) != 0) {
                        return Float.compare(score2, score1);
                    }
                    
                    // If outcome and player score are same, compare based on date (most recent first)
                    return g2.getDate().compareTo(g1.getDate());
                }
            });

            // Retrieve the top 5 games for the player
            List<GameRecord> top5Games = playerGameRecords.subList(0, Math.min(playerGameRecords.size(), 5));

            // Print the top 5 games for the player
            System.out.println("Top 5 Games for Player: " + playerName);
            for (GameRecord gameRecord : top5Games) {
                String outcome;
                switch (gameRecord.getOutcome()) {
                    case 0:
                        outcome = "Tie";
                        break;
                    case 1:
                        outcome = gameRecord.getPlayer1() + " won";
                        break;
                    case 2:
                        outcome = gameRecord.getPlayer2() + " won";
                        break;
                    default:
                        outcome = "Unknown";
                }
                System.out.println(gameRecord.getPlayer1() + " vs " + gameRecord.getPlayer2() +
                        " Outcome: " + outcome + " at " + gameRecord.getDate());
            }
            System.out.println("------------------------------------------");
        } else {
            System.out.println("Player not found in the roster.");
        }
    }

    public Map<String, Player> getPlayersMap() {
        return players;
    }
}