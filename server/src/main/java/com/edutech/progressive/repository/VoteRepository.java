package com.edutech.progressive.repository;
 
import com.edutech.progressive.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import javax.transaction.Transactional;
 
public interface VoteRepository extends JpaRepository<Vote, Integer> {
 
    @Query("select count(v) from Vote v where v.category = :category")
    Long countByCategory(@Param("category") String category);
 
    @Modifying
    @Transactional
    @Query("delete from Vote v where v.team.teamId = :teamId")
    void deleteByTeamId(@Param("teamId") int teamId);
 
    @Modifying
    @Transactional
    @Query("delete from Vote v where v.cricketer.cricketerId = :cricketerId")
    void deleteByCricketerId(@Param("cricketerId") int cricketerId);
}