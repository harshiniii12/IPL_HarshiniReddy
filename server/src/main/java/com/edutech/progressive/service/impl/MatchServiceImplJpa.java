package com.edutech.progressive.service.impl;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.service.MatchService;
 
@Service
public class MatchServiceImplJpa implements MatchService {
 
    @Autowired
    private MatchRepository matchRepository;
 
    @Override
    public List<Match> getAllMatches() throws SQLException {
        return new ArrayList<>();
    }
 
    @Override
    public Match getMatchById(int matchId) throws SQLException {
        return null;
    }
 
    @Override
    public Integer addMatch(Match match) throws SQLException {
        return -1;
    }
 
    @Override
    public void updateMatch(Match match) throws SQLException {
    }
 
    @Override
    public void deleteMatch(int matchId) throws SQLException {
    }
 
    public List<Match> getAllMatchesByStatus(String status) throws SQLException{
        return null;
    }
}