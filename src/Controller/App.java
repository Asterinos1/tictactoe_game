package Controller;
import java.util.concurrent.TimeUnit;

import Model.PlayerRoster;
import View.MainWindow;

public class App {
    public static void main(String[] args) throws InterruptedException {
        PlayerRoster pr = new PlayerRoster();
        //pr.lodDataFromFile();

        pr.addNewPlayer("Asterinos");
        pr.addNewPlayer("John");
        pr.createNewGamerecord("Asterinos", "John", 0);
        TimeUnit.SECONDS.sleep(1);
        pr.printAllPlayersStats();
        pr.createNewGamerecord("Asterinos", "John",1);
        TimeUnit.SECONDS.sleep(1);
        pr.printAllPlayersStats();
        pr.createNewGamerecord("Asterinos", "John",1);
        TimeUnit.SECONDS.sleep(1);
        pr.printAllPlayersStats();
        pr.createNewGamerecord("Asterinos", "John",2);
        TimeUnit.SECONDS.sleep(1);
        pr.printAllPlayersStats();
        pr.createNewGamerecord("Asterinos", "John",0);
        pr.printAllPlayersStats();
        pr.printAllGames();
        pr.printAllPlayersStats();
        pr.saveDataToFile();
        //main logic almost complete.
        /*
        Board brd = new Board();
        brd.printBoard();  
                while(!brd.gameHasFinished() && brd.getMoves()>0) {
                    brd.makeMove();
                    brd.printBoard();
                }
                System.out.println("Game has concluded.");

                if(brd.getWinner()==1){
                    GameRecord gmrcd = new GameRecord(1);
                    System.out.println(gmrcd.getGameInfo());
                }else if(brd.getWinner()==2){
                    GameRecord gmrcd = new GameRecord(2);
                    System.out.println(gmrcd.getGameInfo());
                }else if(brd.getWinner()==0){
                    GameRecord gmrcd = new GameRecord(0);
                    System.out.println(gmrcd.getGameInfo());
                }
         */
        //MainWindow mw = new MainWindow(pr.getPlayersMap());
        //PlayerRoster pr = new PlayerRoster();
        //pr.loadPlayers()

    }
}
