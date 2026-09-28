package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.repository.CourseRepository;
import com.example.onlineexamination.repository.ExamRepository;
import com.example.onlineexamination.repository.StudentAttemptRepository;
import com.example.onlineexamination.repository.UserRepository;
import com.example.onlineexamination.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final ExamRepository examRepository;
    private final StudentAttemptRepository attemptRepository;

    public ReportServiceImpl(UserRepository userRepository,
                             CourseRepository courseRepository,
                             ExamRepository examRepository,
                             StudentAttemptRepository attemptRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
        this.attemptRepository = attemptRepository;
    }

    @Override
    public Map<String, Long> getReports() {

        Map<String, Long> reports = new HashMap<>();

        reports.put("totalUsers", userRepository.count());
        reports.put("totalCourses", courseRepository.count());
        reports.put("totalExams", examRepository.count());
        reports.put("totalAttempts", attemptRepository.count());

        return reports;
    }
}