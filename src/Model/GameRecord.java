package Model;
import java.time.LocalDateTime;

public class GameRecord {

    private Player plr1, plr2;
    private String outcome;
    private int scr1, scr2;
    private LocalDateTime currentTime;

    public GameRecord(int outcome){
        this.currentTime = LocalDateTime.now();
        setGameOutcome(outcome);
    }

    public void setGameOutcome(int outcome) {
        if(outcome == 1){
            this.outcome ="X victory";
        }else if(outcome == 2){
            this.outcome = "O victory";
        }else if(outcome == 0){
            this.outcome = "tie";
        }
    }

    public String getGameInfo(){
        return "Game played at: "+currentTime+" "+outcome;
    }
    public Player getPlr1() {
        return plr1;
    }

    public void setPlr1(Player plr1) {
        this.plr1 = plr1;
    }

    public Player getPlr2() {
        return plr2;
    }

    public void setPlr2(Player plr2) {
        this.plr2 = plr2;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public int getScr1() {
        return scr1;
    }

    public void setScr1(int scr1) {
        this.scr1 = scr1;
    }

    public int getScr2() {
        return scr2;
    }

    public void setScr2(int scr2) {
        this.scr2 = scr2;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}
