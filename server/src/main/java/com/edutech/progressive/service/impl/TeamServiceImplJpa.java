package com.edutech.progressive.service.impl;
 
import java.sql.SQLException;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
 
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.service.TeamService;
 
public class TeamServiceImplJpa implements TeamService {
 
    private TeamRepository teamRepository;
    @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
 
    @Override
    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }
 
    @Override
    public int addTeam(Team team) throws SQLException {
        teamRepository.save(team);
        return getAllTeams().size();
    }
 
    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        return teamRepository.findAllOrderByNameAsc();
    }
 
    public Team getTeamById(int teamId) throws SQLException {
        return teamRepository.findById(teamId).get();
    }
 
    @Override
    public void updateTeam(Team team) throws SQLException {
        Team teamDetails = getTeamById(team.getTeamId());
        teamDetails.setTeamName(team.getTeamName());
        teamDetails.setOwnerName(team.getOwnerName());
        teamDetails.setLocation(team.getLocation());
        teamDetails.setEstablishmentYear(team.getEstablishmentYear());
        teamRepository.save(teamDetails);
    }
 
    @Override
    public void deleteTeam(int teamId) throws SQLException {
        teamRepository.deleteById(teamId);
    }
}