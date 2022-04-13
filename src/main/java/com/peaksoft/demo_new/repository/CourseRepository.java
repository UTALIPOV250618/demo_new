package com.peaksoft.demo_new.repository;

import com.peaksoft.demo_new.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}