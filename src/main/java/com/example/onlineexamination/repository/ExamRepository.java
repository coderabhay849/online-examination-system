package com.example.onlineexamination.repository;

import com.example.onlineexamination.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByPublishedTrue();
}