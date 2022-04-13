package com.peaksoft.demo_new.service;

import com.peaksoft.demo_new.dto.CourseRequest;
import com.peaksoft.demo_new.dto.CourseResponse;
import com.peaksoft.demo_new.model.Course;
import com.peaksoft.demo_new.model.Student;
import com.peaksoft.demo_new.repository.CourseRepository;
import com.peaksoft.demo_new.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;


    public CourseResponse create(CourseRequest courseRequest){
        Course course = mapToEntity(courseRequest);
        courseRepository.save(course);
        return mapToResponse(course);
    }

    public Course mapToEntity(CourseRequest courseRequest){

        Course course = new Course();
        course.setCourseName(courseRequest.getCourse_name());
        return course;
    }

    public CourseResponse mapToResponse(Course course){
//        List<Student> students = new ArrayList<>();
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setCourse_id(course.getCourseId());
        courseResponse.setCourse_name(course.getCourseName());

//        Student student = studentRepository.findById(courseResponse.getCourse_id()).get();
        return courseResponse;
    }
}
