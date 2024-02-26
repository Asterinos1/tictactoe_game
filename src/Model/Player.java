package Model;

public class Player {
    
    private String name;
    private int totalGamesPlayed;
    private int numOfVictories;
    private int numOfDefeats;
    private int numOfDraws;
    private float score;

    public Player(String name){
        this.name = name;
        this.totalGamesPlayed=0;
        this.numOfDefeats=0;
        this.numOfVictories=0;
        this.numOfDraws=0;
        this.score=0;
    }
    
    public void updateScore(){
        this.score += 50*((2*(float)numOfVictories)+(float) numOfDraws)/((float) totalGamesPlayed);
    }

    public void incrementTotalGamesPlayed(){
        this.totalGamesPlayed++;
    }

    public void incrementDefeats(){
        this.numOfDefeats++;
    }

    public void incrementVictories(){
        this.numOfVictories++;
    }

    public void incrementDraws(){
        this.numOfDraws++;
    }

    //setters, getters
    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(int totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public int getNumOfVictories() {
        return numOfVictories;
    }

    public void setNumOfVictories(int numOfVictories) {
        this.numOfVictories = numOfVictories;
    }

    public int getNumOfDefeats() {
        return numOfDefeats;
    }

    public void setNumOfDefeats(int numOfDefeats) {
        this.numOfDefeats = numOfDefeats;
    }

    public int getNumOfDraws() {
        return numOfDraws;
    }

    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }
}
