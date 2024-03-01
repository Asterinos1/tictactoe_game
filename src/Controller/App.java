package Controller;
import Model.PlayerRoster;
import View.MainWindow;

public class App {
    public static void main(String[] args) throws InterruptedException {
        PlayerRoster pr = new PlayerRoster();
        //pr.lodDataFromFile();

        pr.addNewPlayer("Asterinos");
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
        pr.findHallOfFame();
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
        MainWindow mw = new MainWindow();
        //PlayerRoster pr = new PlayerRoster();
        //pr.loadPlayers()

    }
}
