package Model;

import java.time.LocalDateTime;

public class GameRecord {
    private String player1, player2;
    private int outcome;
    private float scr1, scr2;
    private LocalDateTime date;
    
    public GameRecord(String player1, String player2, int oucome, float scr1, float scr2, LocalDateTime date){
        this.player1 = player1;
        this.player2 = player2;
        this.outcome = oucome;
        this.scr1=scr1;
        this.scr2=scr2;
        this.date = date;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int getOutcome() {
        return outcome;
    }

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }

    public float getScore1() {
        return scr1;
    }

    public void setScore1(float scr1) {
        this.scr1 = scr1;
    }

    public float getScore2() {
        return scr2;
    }

    public void setScore2(float scr2) {
        this.scr2 = scr2;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
