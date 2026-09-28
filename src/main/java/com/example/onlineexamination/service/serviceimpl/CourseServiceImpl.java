package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.dto.CourseRequest;
import com.example.onlineexamination.entity.Course;
import com.example.onlineexamination.repository.CourseRepository;
import com.example.onlineexamination.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private static final Logger logger =
            LoggerFactory.getLogger(CourseServiceImpl.class);

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(CourseRequest request) {

        Course course = new Course();

        course.setName(request.getName());
        course.setDescription(request.getDescription());
        logger.info("Course created successfully: {}", course.getName());
        return courseRepository.save(course);
        
    }

    @Override
    public Course updateCourse(Long id, CourseRequest request) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        course.setName(request.getName());
        course.setDescription(request.getDescription());

        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));
        logger.info("Course deleted successfully with id: {}", id);
        courseRepository.delete(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {

        return courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));
    }
    
    @Override
    public Page<Course> getCourses(
            int page,
            int size,
            String sortBy,
            String direction,
            String search) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        if (search != null && !search.isBlank()) {
            return courseRepository.findByNameContainingIgnoreCase(search, pageable);
        }

        return courseRepository.findAll(pageable);
    }
}