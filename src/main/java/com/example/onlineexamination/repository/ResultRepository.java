package com.example.onlineexamination.repository;

import com.example.onlineexamination.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Long> {

    Optional<Result> findByAttemptId(Long attemptId);
}