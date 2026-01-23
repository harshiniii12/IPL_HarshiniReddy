package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

@Service
@Qualifier("teamServiceArrayList")

public class TeamServiceImplArraylist implements TeamService {

    private List<Team> teams = new ArrayList<>();

    @Override
    public List<Team> getAllTeams() throws SQLException {
        return new ArrayList<>(teams);
    }

    @Override
    public int addTeam(Team team) throws SQLException {
        teams.add(team);
        return teams.size();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {

        return teams.stream().sorted(Comparator.comparing(Team::getTeamName,Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))).collect(Collectors.toList());

    }

    @Override
    public void emptyArrayList() {
        this.teams = new ArrayList<>();
    }


    @Override
    public Team getTeamById(int teamId) throws SQLException {
        return null;
    }

    @Override
    public void updateTeam(Team team) throws SQLException {
    }

    @Override
    public void deleteTeam(int teamId) throws SQLException {
    }

}
