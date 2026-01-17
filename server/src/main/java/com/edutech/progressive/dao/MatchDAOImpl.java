package com.edutech.progressive.dao;
import java.util.ArrayList;
import java.util.List;
import com.edutech.progressive.entity.Match;
public class MatchDAOImpl implements MatchDAO{
    @Override
    public int addMatch(Match match) {
        //Placeholder stub
        return -1;
    }
    @Override
    public Match getMatchById(int matchId) {
        //Placeholder stub
        return null;
    }
    @Override
    public void updateMatch(Match match) {
        //Placeholder stub
    }
    @Override
    public void deleteMatch(int matchId) {
        //Placeholder stub
    }
    @Override
    public List<Match> getAllMatches() {
        //Placeholder stub
        return new ArrayList<>();
    }
}