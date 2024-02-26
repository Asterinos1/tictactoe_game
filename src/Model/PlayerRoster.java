package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerRoster{
    private static final String GAMERECORDFILE = "gamerecord.txt";
    //Here we store a list of all the games ever played.
    private List<GameRecord> gameRecords;

    public PlayerRoster(){
        gameRecords = new ArrayList<>();
    }

    public void lodDataFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(GAMERECORDFILE))) {

            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


            while ((line = br.readLine()) != null) {
                // Split the line into parts
                String[] parts = line.split(";");

                // Parse the parts into variables
                String name1 = parts[0];
                String name2 = parts[1];
                int outcome = Integer.parseInt(parts[2]);
                float playerScore1 = Float.parseFloat(parts[3]);
                float playerScore2 = Float.parseFloat(parts[4]);
                LocalDateTime dateTime = LocalDateTime.parse(parts[5], formatter);
                
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
                System.out.println("Date: " + dateTime.format(formatter));
                System.out.println("\n");
                
                // Create a new GameRecord object and add it to the list.
                GameRecord gameRecord = new GameRecord(name1, name2, outcome, playerScore1, playerScore2, dateTime);
                gameRecords.add(gameRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //sorting the records.
        sortGameRecordsByDate();
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

    public void printAllGames(){
        for(int i=0; i<gameRecords.size(); i++){
            System.out.println(gameRecords.get(i).getPlayer1()+" vs " +gameRecords.get(i).getPlayer2()+" at " +gameRecords.get(i).getDate());
        }
    }
}