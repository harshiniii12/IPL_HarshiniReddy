
package com.edutech.progressive.service.impl;
 
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.exception.NoMatchesFoundException;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.service.MatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import java.sql.SQLException;
import java.util.List;
 
@Service
@Transactional
public class MatchServiceImplJpa implements MatchService {
 
    private final MatchRepository matchRepository;
 
    public MatchServiceImplJpa(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
 
    @Override
    @Transactional(readOnly = true)
    public List<Match> getAllMatches() throws SQLException {
        try {
            return matchRepository.findAll();
        } catch (Exception e) {
            throw toSqlException(e);
        }
    }
 
    @Override
    @Transactional(readOnly = true)
    public Match getMatchById(int matchId) throws SQLException {
        try {
            return matchRepository.findById(matchId).orElse(null);
        } catch (Exception e) {
            throw toSqlException(e);
        }
    }
 
    @Override
    public Integer addMatch(Match match) throws SQLException {
        try {
            Match saved = matchRepository.save(match);
            return saved.getMatchId();
        } catch (Exception e) {
            throw toSqlException(e);
        }
    }
 
    @Override
    public void updateMatch(Match match) throws SQLException {
        try {
            matchRepository.save(match);
        } catch (Exception e) {
            throw toSqlException(e);
        }
    }
 
    @Override
    public void deleteMatch(int matchId) throws SQLException {
        try {
            matchRepository.deleteById(matchId);
        } catch (Exception e) {
            throw toSqlException(e);
        }
    }
 
    @Override
    @Transactional(readOnly = true)
    public List<Match> getAllMatchesByStatus(String status) throws SQLException {
        try {
            List<Match> matches = matchRepository.findAllByStatusIgnoreCase(status);
            if (matches == null || matches.isEmpty()) {
                throw new NoMatchesFoundException("No matches found with status '" + status + "'");
            }
            return matches;
        } catch (NoMatchesFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw toSqlException(e);
        }
    }
 
    private SQLException toSqlException(Exception e) {
        return (e instanceof SQLException) ? (SQLException) e : new SQLException(e.getMessage(), e);
    }
}