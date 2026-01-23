package com.edutech.progressive.repository;
 
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.edutech.progressive.entity.Cricketer;
 
public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {
 
    Optional<Cricketer> findByCricketerId(int cricketerId);
    List<Cricketer> findByTeam_TeamId(int teamId);

    @Modifying
    @Transactional
    @Query("delete from Cricketer c where c.team.teamId = :teamId")
    void deleteByTeamId(@Param("teamId") int teamId);

}

 