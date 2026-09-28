package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.dto.AnswerRequest;
import com.example.onlineexamination.dto.StartAttemptResponse;
import com.example.onlineexamination.dto.SubmitAttemptRequest;
import com.example.onlineexamination.entity.*;
import com.example.onlineexamination.repository.*;
import com.example.onlineexamination.service.AttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttemptServiceImpl implements AttemptService {

    private final StudentAttemptRepository attemptRepository;
    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final OptionRepository optionRepository;
    private final ResultRepository resultRepository;

    public AttemptServiceImpl(StudentAttemptRepository attemptRepository,
                              ExamRepository examRepository,
                              UserRepository userRepository,
                              QuestionRepository questionRepository,
                              OptionRepository optionRepository,
                              ResultRepository resultRepository) {

        this.attemptRepository = attemptRepository;
        this.examRepository = examRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public StartAttemptResponse startAttempt(Long examId, String email) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        User student = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<StudentAttempt> attempts =
                attemptRepository.findByStudentIdAndExamId(
                        student.getId(), examId);

        int attemptNumber = attempts.size() + 1;

        LocalDateTime startTime = LocalDateTime.now();

        LocalDateTime endTime =
                startTime.plusMinutes(exam.getDurationMinutes());

        StudentAttempt attempt = new StudentAttempt();

        attempt.setExam(exam);
        attempt.setStudent(student);
        attempt.setStartTime(startTime);
        attempt.setEndTime(endTime);
        attempt.setAttemptNumber(attemptNumber);
        attempt.setSubmitted(false);
        attempt.setScore(0.0);

        attemptRepository.save(attempt);

        return new StartAttemptResponse(
                attempt.getId(),
                exam.getId(),
                startTime,
                endTime,
                attemptNumber
        );
    }

    @Override
    public Double submitAttempt(Long attemptId,
                                String email,
                                SubmitAttemptRequest request) {

        StudentAttempt attempt = attemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found"));

        if (!attempt.getStudent().getEmail().equals(email)) {
            throw new RuntimeException("You cannot submit this attempt");
        }

        if (attempt.isSubmitted()) {
            throw new RuntimeException("Attempt already submitted");
        }
        if (LocalDateTime.now().isAfter(attempt.getEndTime())) {
            attempt.setSubmitted(true);
            attemptRepository.save(attempt);
            throw new RuntimeException("Exam time is over");
        }

        double score = 0.0;

        for (AnswerRequest answer : request.getAnswers()) {

            Question question = questionRepository
                    .findById(answer.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            Option option = optionRepository
                    .findById(answer.getSelectedOptionId())
                    .orElseThrow(() -> new RuntimeException("Option not found"));

            if (option.isCorrect()) {
                score += question.getMarks();
            } else {
                score -= question.getNegativeMarks();
            }
        }

        if (score < 0) {
            score = 0;
        }

        attempt.setScore(score);
        attempt.setSubmitted(true);

        attemptRepository.save(attempt);

        Result result = new Result();

        result.setAttempt(attempt);
        result.setScore(score);
        result.setTotalMarks(attempt.getExam().getTotalMarks());

        double percentage =
                (score / attempt.getExam().getTotalMarks()) * 100;

        result.setPercentage(percentage);
        result.setPassed(percentage >= 40);

        resultRepository.save(result);

        return score;
    }

    @Override
    public List<StudentAttempt> getHistory(String email) {

        User student = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return attemptRepository.findByStudentId(student.getId());
    }
}