package Controller;
import Model.PlayerRoster;
import View.MainWindow;

public class App {
    public static void main(String[] args) {
        PlayerRoster pr = new PlayerRoster();
        pr.lodDataFromFile();

        pr.addNewPlayer("Asterinos");
        pr.addNewPlayer("Giolddaskjhdkashdkjahdkjahkjsdhakjhasis");
        pr.createNewGamerecord("Asterinos", "john", 1);
        pr.createNewGamerecord("Asterinos", "john", 1);
        pr.createNewGamerecord("Asterinos", "john", 1);
        pr.createNewGamerecord("Asterinos", "john", 1);
        pr.createNewGamerecord("Asterinos", "john", 1);
        pr.createNewGamerecord("Asterinos", "john", 1);
        pr.printAllGames();
        pr.printAllPlayersStats();
        pr.getTop5RecentGamesForPlayer("john");
        pr.getTop5GamesForPlayer("john");
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
        MainWindow mw = new MainWindow(pr.getPlayersMap());
        //PlayerRoster pr = new PlayerRoster();
        //pr.loadPlayers()

    }
}
