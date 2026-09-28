package com.example.onlineexamination.service;

import com.example.onlineexamination.entity.StudentAttempt;
import com.example.onlineexamination.repository.StudentAttemptRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AutoSubmitScheduler {

    private final StudentAttemptRepository attemptRepository;

    public AutoSubmitScheduler(StudentAttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    @Scheduled(fixedRate = 30000)
    public void autoSubmitAttempts() {

        List<StudentAttempt> attempts =
                attemptRepository.findBySubmittedFalse();

        for (StudentAttempt attempt : attempts) {

            if (LocalDateTime.now().isAfter(attempt.getEndTime())) {
                attempt.setSubmitted(true);
                attempt.setScore(0.0);
                attemptRepository.save(attempt);
            }
        }
    }
}