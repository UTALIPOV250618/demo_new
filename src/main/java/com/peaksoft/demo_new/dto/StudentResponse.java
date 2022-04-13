package com.peaksoft.demo_new.dto;


import com.peaksoft.demo_new.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String student_id;
    private String student_name;
    private String student_lastname;
    private Course course;
}
