package com.edutech.progressive.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Team;
 

public interface TeamRepository extends JpaRepository<Team, Integer>{
    Team findByTeamId(int teamId);
}