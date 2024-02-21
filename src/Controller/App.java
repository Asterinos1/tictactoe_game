package Controller;
import Model.Board;
import Model.GameRecord;
import Model.Player;

public class App {
    public static void main(String[] args) {
        Board brd = new Board();
        

        brd.printBoard();
       
        while(!brd.getGameState()) {
            brd.makeMove();
            brd.printBoard();
        }

       


    }
}
