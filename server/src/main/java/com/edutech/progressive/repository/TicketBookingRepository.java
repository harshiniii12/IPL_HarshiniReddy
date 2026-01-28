package com.edutech.progressive.repository;
 
import com.edutech.progressive.entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import javax.transaction.Transactional;
import java.util.List;
 
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {
 
    // For GET /ticket/user/{email}
    List<TicketBooking> findByEmail(String email);
 
    
    @Modifying
    @Transactional
    @Query("delete from TicketBooking tb where tb.match.matchId = :matchId")
    void deleteByMatchId(@Param("matchId") int matchId);
 
   
    @Modifying
    @Transactional
    @Query("delete from TicketBooking tb " +
           "where tb.match.firstTeamId = :teamId or tb.match.secondTeamId = :teamId")
    void deleteByTeamId(@Param("teamId") int teamId);
}