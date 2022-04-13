package com.peaksoft.demo_new.controller;


import com.peaksoft.demo_new.dto.StudentRequest;
import com.peaksoft.demo_new.dto.StudentResponse;
import com.peaksoft.demo_new.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {


    public StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest studentRequest){
        return studentService.create(studentRequest);
    }

    @PutMapping("{id}")
    public StudentResponse update(@PathVariable long id, StudentRequest studentRequest){
        return studentService.update(id,studentRequest);
    }
}
