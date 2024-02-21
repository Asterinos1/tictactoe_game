package Model;
import java.util.Scanner;

public class Board {
    //Flag is used to alternate between player turns.
    private Boolean flag = true;
    //gameHasFinished checks whether the game is finished.
    private Boolean gameHasFinished=false;
    //winner -> True: X victory.
    //False: O victory.
    private Boolean winner = null;

    //Creating board.
    private static final int MTRX_DMNSN = 3;
    private char board[][] = new char[MTRX_DMNSN][MTRX_DMNSN];
    
    //Temporary scanner.
    Scanner scanner = new Scanner(System.in);

    //print current state.
    public void printBoard(){
        for(int i=0; i<MTRX_DMNSN; i++){
            for(int j=0; j<MTRX_DMNSN; j++){
                System.out.print(board[i][j]+" ("+i+", "+j+")  ");
            }
            
            System.out.println("\n");
        }
    }
    
    //board initialization.
    public void initializeBoard(){
        for(int i=0; i<MTRX_DMNSN; i++){
            for(int j=0; j<MTRX_DMNSN; j++){
                board[i][j]='E';
            }
        }
    }

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

            setMatrixBlock(a, b, flag);

            if(checkForVictory('X')){
                System.out.println("Player1(X) has won!");
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

            setMatrixBlock(a, b, flag);
            
            if(checkForVictory('O')){
                System.out.println("Player2(O) has won!");
            }
            this.flag=true;
        }

    }   

    public void setMatrixBlock(int a, int b, boolean flag){
        if(flag==true){
            this.board[a][b]='X';
        }else if(flag==false){
            this.board[a][b]='O';
        }

    }

    public boolean isAvailablePosition(int a, int b){
        if(this.board[a][b]=='E'){
            return true;
        }
        return false;
    }

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
    public Board(){
        initializeBoard();
    }
    
    public boolean getGameState(){
        return this.gameHasFinished;
    }
}
