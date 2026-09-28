package com.example.onlineexamination.service;

import com.example.onlineexamination.dto.CourseRequest;
import com.example.onlineexamination.entity.Course;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CourseService {

    Course createCourse(CourseRequest request);

    Course updateCourse(Long id, CourseRequest request);

    void deleteCourse(Long id);

    List<Course> getAllCourses();

    Course getCourseById(Long id);
    
    Page<Course> getCourses(int page, int size, String sortBy, String direction, String search);
}