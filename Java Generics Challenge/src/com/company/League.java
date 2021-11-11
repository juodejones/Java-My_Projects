package com.company;
import java.util.Collections;
import  java.util.LinkedList;
public class League<T extends Team> {
    private String leagueName;
    private LinkedList<T> leagueList;

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.leagueList = new LinkedList<>();
    }

    public String getLeagueName() {
        return leagueName;
    }

    public boolean addTeam(T team) {
        if (this.leagueList.contains(team)) {
            System.out.println("Team already exists!!!");
            return false;
        } else {
            this.leagueList.add(team);
            System.out.println(team.getTeamName() + " team successfully added!!");
            return true;
        }
    }
    public void printLeagueList() {
        Collections.sort(this.leagueList);
        System.out.println();
        for (T i : this.leagueList ){
            System.out.println(i.getTeamName() + " - " + i.rank());
        }
    }
}
