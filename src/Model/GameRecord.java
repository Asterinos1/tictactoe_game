package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class GameRecord {
    String fileName = "gamerecird.txt";

    public GameRecord(){
        
    }

    public void lodDataFromFile(){
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into parts
                String[] parts = line.split(":");

                // Parse the parts into variables
                String name1 = parts[0];
                String name2 = parts[1];
                int outcome = Integer.parseInt(parts[2]);
                float playerScore1 = Float.parseFloat(parts[3]);
                float playerScore2 = Float.parseFloat(parts[4]);
                Date date = new Date(parts[5]); // Assuming the date is in a format that can be parsed by Date

                // Process or store the data as needed
                System.out.println("Name1: " + name1);
                System.out.println("Name2: " + name2);
                System.out.println("Outcome: " + outcome);
                System.out.println("Player Score1: " + playerScore1);
                System.out.println("Player Score2: " + playerScore2);
                System.out.println("Date: " + date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
