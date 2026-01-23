package com.edutech.progressive.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.edutech.progressive.entity.Match;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    List<Match> findAllByStatusIgnoreCase(String status);

}
