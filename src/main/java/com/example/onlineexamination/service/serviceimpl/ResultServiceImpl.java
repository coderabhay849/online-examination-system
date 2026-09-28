package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.entity.Result;
import com.example.onlineexamination.entity.StudentAttempt;
import com.example.onlineexamination.repository.ResultRepository;
import com.example.onlineexamination.repository.StudentAttemptRepository;
import com.example.onlineexamination.service.ResultService;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;
    private final StudentAttemptRepository attemptRepository;

    public ResultServiceImpl(ResultRepository resultRepository,
                             StudentAttemptRepository attemptRepository) {
        this.resultRepository = resultRepository;
        this.attemptRepository = attemptRepository;
    }

    @Override
    public Result getResult(Long attemptId, String email) {

        StudentAttempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        if (!attempt.getStudent().getEmail().equals(email)) {
            throw new RuntimeException("You cannot view this result");
        }

        return resultRepository.findByAttemptId(attemptId)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }
}