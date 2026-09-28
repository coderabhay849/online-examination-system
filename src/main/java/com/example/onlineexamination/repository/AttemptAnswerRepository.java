package com.example.onlineexamination.repository;

import com.example.onlineexamination.entity.AttemptAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptAnswerRepository extends JpaRepository<AttemptAnswer, Long> {
}