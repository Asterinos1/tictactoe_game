package Controller;
import Model.Board;
import Model.PlayerRoster;
import View.MainWindow;

public class App {
    public static void main(String[] args) throws InterruptedException {
        PlayerRoster pr = new PlayerRoster();
        Board board = new Board();
        //pr.lodDataFromFile();
        MainWindow mw = new MainWindow(board, pr);

        /* pr.addNewPlayer("Asterinos");
        pr.addNewPlayer("John");
        pr.addNewPlayer("George");
        pr.addNewPlayer("Eleni");
        pr.printCurrentRoaster();

        pr.createNewGamerecord("Asterinos", "John", 0);    
        pr.createNewGamerecord("Asterinos", "Eleni",1);       
        pr.createNewGamerecord("John", "Asterinos",1);      
        pr.createNewGamerecord("George", "Eleni",2);
        pr.createNewGamerecord("Asterinos", "George",0);

        pr.printAllGames();
        pr.printAllPlayersStats();

        pr.saveDataToFile();
        pr.findHallOfFame();*/
    }
}