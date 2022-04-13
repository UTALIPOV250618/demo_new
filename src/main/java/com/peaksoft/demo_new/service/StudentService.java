package com.peaksoft.demo_new.service;

import com.peaksoft.demo_new.dto.StudentRequest;
import com.peaksoft.demo_new.dto.StudentResponse;
import com.peaksoft.demo_new.model.Course;
import com.peaksoft.demo_new.model.Student;
import com.peaksoft.demo_new.repository.CourseRepository;
import com.peaksoft.demo_new.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;


    public  StudentResponse create(StudentRequest studentRequest){
            Student student = mapToEntity(studentRequest);
            studentRepository.save(student);
            return mapToResponse(student);
    }

    public StudentResponse update(Long id,StudentRequest studentRequest){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            System.out.println("Student with this 'ID' doest not exist");
        }
         mapToUpdate(student.get(),studentRequest);

         return mapToResponse(studentRepository.save(student.get()));
    }

    public StudentResponse getById(long id){
        Optional<Student> student = studentRepository.findById(id);

        /* isEmpty method belongs to Optional*/

        if (student.isEmpty()){
            System.out.println("Student with this 'ID' doest not exist");
        }

        return mapToResponse(studentRepository.findById(id).get());
    }
    public StudentResponse delete(long id){
        Student student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        return mapToResponse(student);

    }

    public Student mapToEntity(StudentRequest studentRequest){

        Student student = new Student();
        student.setStudentName(studentRequest.getStudent_name());
        student.setStudentLastName(studentRequest.getStudent_lastname());
        student.setStudentLastName(studentRequest.getStudent_lastname());
        Course course = courseRepository.findById(studentRequest.getCourseId()).get();
        student.setCourse(course);
        return student;
    }

    public Student mapToUpdate(Student student, StudentRequest studentRequest){
        student.setStudentName(studentRequest.getStudent_name());
        student.setStudentLastName(studentRequest.getStudent_lastname());
        student.setStudentLastName(studentRequest.getStudent_lastname());
        Course course = courseRepository.findById(studentRequest.getCourseId()).get();
        student.setCourse(course);
        return student;
    }

    public StudentResponse mapToResponse(Student student){
        StudentResponse response = new StudentResponse();
        response.setStudent_id(String.valueOf(student.getStudentId()));
        response.setStudent_name(student.getStudentName());
        response.setStudent_lastname(student.getStudentLastName());
        response.setCourse(student.getCourse());
        return response;
    }



}
