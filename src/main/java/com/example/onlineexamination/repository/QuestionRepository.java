package com.example.onlineexamination.repository;

import com.example.onlineexamination.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}