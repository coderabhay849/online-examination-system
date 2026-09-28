package com.example.onlineexamination.service;

import com.example.onlineexamination.dto.CourseRequest;
import com.example.onlineexamination.entity.Course;
import com.example.onlineexamination.repository.CourseRepository;
import com.example.onlineexamination.service.serviceimpl.CourseServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @Test
    void createCourseTest() {

        CourseRequest request = new CourseRequest();
        request.setName("Java");
        request.setDescription("Java Programming");

        Course course = new Course();
        course.setName("Java");
        course.setDescription("Java Programming");

        when(courseRepository.save(org.mockito.ArgumentMatchers.any(Course.class)))
                .thenReturn(course);

        Course result = courseService.createCourse(request);

        assertEquals("Java", result.getName());
        assertEquals("Java Programming", result.getDescription());
    }
}