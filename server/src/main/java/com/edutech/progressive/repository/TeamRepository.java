package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.progressive.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    List<Team> findAllOrderByNameAsc();
}
