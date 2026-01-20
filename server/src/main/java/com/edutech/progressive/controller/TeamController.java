package com.edutech.progressive.controller;
 
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.impl.TeamServiceImplArraylist;
import com.edutech.progressive.service.impl.TeamServiceImplJdbc;
import com.edutech.progressive.service.impl.TeamServiceImplJpa;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.sql.SQLException;
import java.util.List;
 
@RestController
@RequestMapping("/team")
public class TeamController {
 
    @Autowired
    private TeamServiceImplArraylist teamServiceImplArraylist;
 
    @Autowired
    private TeamServiceImplJpa teamServiceImplJpa;
 
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        try {
            return new ResponseEntity<>(teamServiceImplJpa.getAllTeams(),HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);   
        }
    }
 
    @GetMapping("/{teamId}")
    public ResponseEntity<Team> getTeamById(@PathVariable int teamId) {
        try {
            return new ResponseEntity<>(teamServiceImplJpa.getTeamById(teamId),HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
 
    @PostMapping("/{team}")
    public ResponseEntity<Integer> addTeam(@PathVariable Team team) {
        try {
            return new ResponseEntity<>(teamServiceImplJpa.addTeam(team),HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @PutMapping("/{teamId}")
    public ResponseEntity<Void> updateTeam(@PathVariable int teamId, Team team) {
        try {
            teamServiceImplJpa.updateTeam(team);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int teamId) {
        try {
            teamServiceImplJpa.deleteTeam(teamId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Team>> getAllTeamsFromArrayList() {
        return new ResponseEntity<>(teamServiceImplArraylist.getAllTeams(),HttpStatus.OK);
    }
 
    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addTeamToArrayList(@RequestBody Team team) {
        return new ResponseEntity<>(teamServiceImplArraylist.addTeam(team),HttpStatus.CREATED);
    }
 
    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Team>> getAllTeamsSortedByNameFromArrayList() {
        return new ResponseEntity<>(teamServiceImplArraylist.getAllTeamsSortedByName(),HttpStatus.OK);
    }
}
