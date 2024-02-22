package Model;
import java.util.ArrayList;
import java.util.Scanner;

//This class represents the board's logic.
public class Board {
    //Flag is used to alternate between player turns.
    private Boolean flag = true;
    //gameHasFinished checks whether the game is finished.
    private Boolean gameHasFinished=false;
    //winner -> 1: X victory.
    //winner -> 2: O victory.
    //winner -> 0: stalemate.
    private int winner = 0;

    //total amount of moves that can be made.
    private int moves;

    //Creating board.
    private static final int MTRX_DMNSN = 3;
    private char board[][] = new char[MTRX_DMNSN][MTRX_DMNSN];
    
    //Temporary scanner.
    Scanner scanner = new Scanner(System.in);

    //print current board state.
    public void printBoard(){
        System.out.println("Current state of the board:");
        for(int i=0; i<MTRX_DMNSN; i++){
            for(int j=0; j<MTRX_DMNSN; j++){
                System.out.print(board[i][j]+" ("+i+", "+j+")  ");
            }
            System.out.println("\n");
        }
    }
    
    //board initialization. E indicates "empty spot".
    public void initializeBoard(){
        for(int i=0; i<MTRX_DMNSN; i++){
            for(int j=0; j<MTRX_DMNSN; j++){
                board[i][j]='E';
            }
        }
    }

    //Temporary function that allows players to make moves.
    public void makeMove(){
        if(flag==true){
            int a,b;
            while(true){
                System.out.println("Player1 (X) select block[A.B]");
                String input = scanner.nextLine();
                String[] parts = input.split("\\.");

                a = Integer.parseInt(parts[0]);
                b = Integer.parseInt(parts[1]);

                if(isAvailablePosition(a, b)){
                    break;
                }
            }
            moves--;
            setMatrixBlock(a, b, flag);

            if(checkForVictory('X')){
                //System.out.println("Player1(X) has won!");
                setWinner(1);
            }
            this.flag=false;
            
        }else if(flag==false){

            int a,b;
            while(true){
                System.out.println("Player2 (O) select block[A.B]");
                String input = scanner.nextLine();
                String[] parts = input.split("\\.");

                a = Integer.parseInt(parts[0]);
                b = Integer.parseInt(parts[1]);

                if(isAvailablePosition(a, b)){
                    break;
                }
            }
            moves--;
            setMatrixBlock(a, b, flag);
            
            if(checkForVictory('O')){
                //System.out.println("Player2(O) has won!");
                setWinner(2);
            }
            this.flag=true;
        }

    }   

    //helper function of  makeMove()
    public void setMatrixBlock(int a, int b, boolean flag){
        if(flag==true){
            this.board[a][b]='X';
        }else if(flag==false){
            this.board[a][b]='O';
        }

    }

    //Function to check for the availability of a pos on the board.
    public boolean isAvailablePosition(int a, int b){
        if(this.board[a][b]=='E'){
            return true;
        }
        return false;
    }

    //Function to check for any victory condition.
    public boolean checkForVictory(char a){
        if(this.board[0][0]==a && this.board[0][1]==a && this.board[0][2]==a){
            this.gameHasFinished=true;
            return true;
        }else if(this.board[1][0]==a && this.board[1][1]==a && this.board[1][2]==a){
            this.gameHasFinished=true;
            return true;
        }else if(this.board[2][0]==a && this.board[2][1]==a && this.board[2][2]==a){
            this.gameHasFinished=true;
            return true;
        }else if(this.board[0][0]==a && this.board[1][0]==a && this.board[2][0]==a){
            this.gameHasFinished=true;
            return true;
        }else if(this.board[0][1]==a && this.board[1][1]==a && this.board[2][1]==a){
            this.gameHasFinished=true;
            return true;
        }else if(this.board[0][2]==a && this.board[1][2]==a && this.board[2][2]==a){
            this.gameHasFinished=true;
            return true;
        }else if(this.board[0][0]==a && this.board[1][1]==a && this.board[2][2]==a){
            this.gameHasFinished=true;
            return true;
        }else if(this.board[0][2]==a && this.board[1][1]==a && this.board[2][0]==a){
            this.gameHasFinished=true;
            return true;
        }
        return false;
    }

    //Contructor.
    public Board(){
        initializeBoard();
        this.moves=9;
    }
    
    //Returns true if the game has finished.
    //Returns false on the opposite.
    public boolean gameHasFinished(){
        return this.gameHasFinished;
    }


    public int bestMoves(char brd[][], char a, int moves){
    
        char[][] dummyBoard = brd;

        ArrayList<String> bestMoves = new ArrayList();
        int bestOutcome=0;

        for(int i=0; i<MTRX_DMNSN; i++){
            for(int j=0; j<MTRX_DMNSN; j++){
                if(dummyBoard[i][j]=='E'){
                    dummyBoard[i][j]=a;
                    moves--;
                    //Curr player victory!
                    if(checkForVictory(a)){
                        bestOutcome=1;
                    }else if(checkForVictory(getOppositeChar(a))){
                        bestOutcome=-1;
                    }else if(moves==0 && 
                    !checkForVictory(a) && 
                    !checkForVictory(getOppositeChar(a))){ 
                        bestOutcome=0;
                    }else{
                        bestOutcome= Math.max(bestOutcome, 
                        bestMoves(dummyBoard, a, moves));
                    }
                }
            }
        }
        return bestOutcome;
    }

    public char getOppositeChar(char a){
        if(a=='X'){
            return 'O';
        }else if(a=='O'){
            return 'X';
        }
        return 'E';
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public void randomPlayStyle(){

    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }
}
