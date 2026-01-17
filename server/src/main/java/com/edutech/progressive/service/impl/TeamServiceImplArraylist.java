package com.edutech.progressive.service.impl;
 
import java.util.ArrayList;

import java.util.Collections;

import java.util.List;
 
import com.edutech.progressive.entity.Team;

import com.edutech.progressive.service.TeamService;
 
public class TeamServiceImplArraylist implements TeamService {
 
    private List<Team> teams = new ArrayList<>();
 
    public TeamServiceImplArraylist() {

        // Sample in-memory data

        teams.add(new Team(101, "Royal Challengers Bengaluru", "Bengaluru", "United Spirits", 2008));

        teams.add(new Team(102, "Mumbai Indians", "Mumbai", "Reliance", 2008));

        teams.add(new Team(103, "Rajasthan Royals", "Jaipur", "Emerging Media", 2008));

        teams.add(new Team(104, "Gujarat Titans", "Ahmedabad", "CVC Capital", 2021));

        teams.add(new Team(105, "Chennai Super Kings", "Chennai", "India Cements", 2008));

    }
 
    @Override

    public List<Team> getAllTeams() {

        return new ArrayList<>(teams);

    }
 
    @Override

    public int addTeam(Team team) {

        teams.add(team);

        return teams.size();

    }
 
    @Override

    public List<Team> getAllTeamsSortedByName() {

        List<Team> copy = new ArrayList<>(teams);

        Collections.sort(copy);

        return copy;

    }
 
    @Override

    public void emptyArrayList() {

        teams = new ArrayList<>();

    }
 
    @Override

    public Team getTeamById(int teamId) {

        for (Team t : teams) {

            if (t.getTeamId() == teamId) return t;

        }

        return null;

    }
 
    @Override

    public void updateTeam(Team team) {

        if (team == null) return;

        for (int i = 0; i < teams.size(); i++) {

            if (teams.get(i).getTeamId() == team.getTeamId()) {

                teams.set(i, team);

                return;

            }

        }

    }
 
    @Override

    public void deleteTeam(int teamId) {

        teams.removeIf(t -> t.getTeamId() == teamId);

    }

}

 