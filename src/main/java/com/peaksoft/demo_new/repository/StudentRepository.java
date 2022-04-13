package com.peaksoft.demo_new.repository;

import com.peaksoft.demo_new.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}