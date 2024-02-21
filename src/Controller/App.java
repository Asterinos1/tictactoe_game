package Controller;
import Model.Board;
import Model.GameRecord;
import Model.Player;

public class App {
    public static void main(String[] args) {
        Board brd = new Board();
        
        Player plr1 = new Player("Nikos");
        Player plr2 = new Player("Georgios");
        brd.printBoard();
       
        while(!brd.getGameState()) {
            brd.makeMove();
            brd.printBoard();
        }

        GameRecord gmrcd = new GameRecord(plr1, plr2, 0, 0, );


    }
}
