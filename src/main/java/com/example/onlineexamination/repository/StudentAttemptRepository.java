package com.example.onlineexamination.repository;

import com.example.onlineexamination.entity.StudentAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAttemptRepository extends JpaRepository<StudentAttempt, Long> {

    List<StudentAttempt> findByStudentIdAndExamId(Long studentId, Long examId);

    List<StudentAttempt> findByStudentId(Long studentId);
    
    List<StudentAttempt> findBySubmittedFalse();
}