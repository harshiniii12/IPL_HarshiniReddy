package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.progressive.entity.Cricketer;

public interface CricketerRepository extends JpaRepository<Cricketer,Long> {
    List<Cricketer> findByTeamId(int teamId);
}
