package com.example.onlineexamination.dto;

import java.time.LocalDateTime;

public class StartAttemptResponse {

    private Long attemptId;
    private Long examId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer attemptNumber;

    public StartAttemptResponse(Long attemptId, Long examId,
                                LocalDateTime startTime,
                                LocalDateTime endTime,
                                Integer attemptNumber) {
        this.attemptId = attemptId;
        this.examId = examId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attemptNumber = attemptNumber;
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public Long getExamId() {
        return examId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }
}