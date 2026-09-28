package com.example.onlineexamination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineexamination.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByNameContainingIgnoreCase(
            String name,
            Pageable pageable
    );
}