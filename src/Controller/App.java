package Controller;
import Model.PlayerRoster;

public class App {
    public static void main(String[] args) {
        PlayerRoster pr = new PlayerRoster();
        pr.lodDataFromFile();

        pr.printAllGames();
        pr.printAllPlayersStats();
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
        //new MainWindow();
        //PlayerRoster pr = new PlayerRoster();
        //pr.loadPlayers();
    }
}
