package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.progressive.entity.Match;

public interface MatchRepository extends JpaRepository<Match,Long> {
    List<Math> findByStatusIgnoreCase(String status);
}
