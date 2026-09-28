package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.dto.ExamRequest;
import com.example.onlineexamination.entity.Course;
import com.example.onlineexamination.entity.Exam;
import com.example.onlineexamination.repository.CourseRepository;
import com.example.onlineexamination.repository.ExamRepository;
import com.example.onlineexamination.service.ExamService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final CourseRepository courseRepository;

    public ExamServiceImpl(ExamRepository examRepository,
                           CourseRepository courseRepository) {
        this.examRepository = examRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Exam createExam(ExamRequest request) {

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        Exam exam = new Exam();

        exam.setTitle(request.getTitle());
        exam.setDescription(request.getDescription());
        exam.setDurationMinutes(request.getDurationMinutes());
        exam.setTotalMarks(request.getTotalMarks());
        exam.setNegativeMark(request.getNegativeMark());
        exam.setPublished(false);
        exam.setCourse(course);

        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Long id, ExamRequest request) {

        Exam exam = examRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Exam not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        exam.setTitle(request.getTitle());
        exam.setDescription(request.getDescription());
        exam.setDurationMinutes(request.getDurationMinutes());
        exam.setTotalMarks(request.getTotalMarks());
        exam.setNegativeMark(request.getNegativeMark());
        exam.setCourse(course);

        return examRepository.save(exam);
    }

    @Override
    public Exam getExamById(Long id) {

        return examRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Exam not found"));
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public String publishExam(Long id) {

        Exam exam = examRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Exam not found"));

        exam.setPublished(true);

        examRepository.save(exam);

        return "Exam published successfully";
    }
}