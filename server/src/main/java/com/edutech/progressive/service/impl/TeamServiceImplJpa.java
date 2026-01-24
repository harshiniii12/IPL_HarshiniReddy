package com.edutech.progressive.service.impl;
 
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.exception.TeamAlreadyExistsException;
import com.edutech.progressive.exception.TeamDoesNotExistException;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.service.TeamService;
 
@Service
public class TeamServiceImplJpa implements TeamService {
    private final TeamRepository teamRepository;
 
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
        if (team == null || team.getTeamName() == null) {
            throw new IllegalArgumentException("Team and team name must not be null");
        }
 
        Team existing = teamRepository.findByTeamName(team.getTeamName());
        if (existing != null) {
            throw new TeamAlreadyExistsException(
                "Team with name '" + team.getTeamName() + "' already exists"
            );
        }
 
        return teamRepository.save(team).getTeamId();
    }
 
    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> sortedTeam = teamRepository.findAll();
        sortedTeam.sort(Comparator.comparing(Team::getTeamName));
        return sortedTeam;
    }
 
    @Override
    public Team getTeamById(int teamId) throws SQLException {
        Team team = teamRepository.findByTeamId(teamId);
        if (team == null) {
            throw new TeamDoesNotExistException("Team with id " + teamId + " does not exist");
        }
        return team;
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
        getTeamById(teamId);
        teamRepository.deleteById(teamId);
    }
}

 