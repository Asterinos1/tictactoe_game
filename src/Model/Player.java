package Model;

public class Player {
    
    private String name;
    private int totalGamesPlayed;
    private int numOfVictories;
    private int numOfDefeats;
    private int numOfDraws;

    public Player(String name){
        this.name = name;
        this.totalGamesPlayed=0;
        this.numOfDefeats=0;
        this.numOfVictories=0;
        this.numOfDraws=0;
    }
    
    public Player(String name, int a, int b, int c, int d){
        this.name = name;
        this.totalGamesPlayed=a;
        this.numOfVictories=b;
        this.numOfDefeats=c;
        this.numOfDraws=d;
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
