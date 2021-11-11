package com.company;
import java.util.LinkedList;
public class Team<P extends Player> implements Comparable<Team<P>> {

    private String teamName;
    private int played = 0 ;
    private int won = 0 ;
    private int lost = 0;
    private int tied = 0;

    private LinkedList<P> teamList;

    public Team(String teamName) {
        this.teamName = teamName;
        this.teamList = new LinkedList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean addToTeam(P player) {

        if (teamList.contains(player)){
            return false;
        } else {
            this.teamList.add(player);
            return true;
        }
    }

    public int numberOfPlayers() {
        System.out.print("Number of players: ");
        return this.teamList.size();
    }

    public void matchResult(Team<P> opponent, int ourScore, int theirScore){

        String message;

        if( ourScore > theirScore){
            won++;
            message = " beat ";
        }else if( theirScore > ourScore){
            lost++;
            message = " lost to ";
        }else{
            tied++;
            message = " drew with ";
        }
        played++;

        if (opponent != null) {
            System.out.println(this.getTeamName() + message + opponent.getTeamName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int rank(){
        return (won * 3) + tied;
    }

    @Override
    public int compareTo(Team<P> team) {
        if (this.rank() > team.rank()) {
            return -1;
        }else if (this.rank() < team.rank()) {
            return 1;
        } else {
            return 0;
        }
    }
}
