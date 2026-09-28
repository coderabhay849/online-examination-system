package com.example.onlineexamination.controller;

import com.example.onlineexamination.dto.CourseRequest;
import com.example.onlineexamination.entity.Course;
import com.example.onlineexamination.service.CourseService;
import org.springframework.data.domain.Page;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(
            @Valid @RequestBody CourseRequest request) {

        return ResponseEntity.ok(
                courseService.createCourse(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequest request) {

        return ResponseEntity.ok(
                courseService.updateCourse(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(
            @PathVariable Long id) {

        courseService.deleteCourse(id);

        return ResponseEntity.ok("Course deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {

        return ResponseEntity.ok(
                courseService.getAllCourses()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                courseService.getCourseById(id)
        );
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Course>> getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) String search) {

        return ResponseEntity.ok(
                courseService.getCourses(page, size, sortBy, direction, search)
        );
    }
    @PutMapping("/{courseId}/assign-instructor/{instructorId}")
    public ResponseEntity<Course> assignInstructor(
            @PathVariable Long courseId,
            @PathVariable Long instructorId) {

        return ResponseEntity.ok(
                courseService.assignInstructor(courseId, instructorId)
        );
    }
    
}