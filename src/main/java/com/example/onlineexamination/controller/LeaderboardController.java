package com.example.onlineexamination.controller;

import com.example.onlineexamination.entity.StudentAttempt;
import com.example.onlineexamination.repository.StudentAttemptRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/student/leaderboard")
public class LeaderboardController {

    private final StudentAttemptRepository attemptRepository;

    public LeaderboardController(StudentAttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    @GetMapping("/{examId}")
    public ResponseEntity<List<StudentAttempt>> getLeaderboard(
            @PathVariable Long examId) {

        List<StudentAttempt> attempts =
                attemptRepository.findAll()
                        .stream()
                        .filter(a -> a.getExam().getId().equals(examId))
                        .filter(StudentAttempt::isSubmitted)
                        .sorted(Comparator.comparing(
                                StudentAttempt::getScore).reversed())
                        .toList();

        return ResponseEntity.ok(attempts);
    }
}