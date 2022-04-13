package com.peaksoft.demo_new.controller;

import com.peaksoft.demo_new.dto.CourseRequest;
import com.peaksoft.demo_new.dto.CourseResponse;
import com.peaksoft.demo_new.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/course")
public class CourseController {

    public CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponse create(@RequestBody CourseRequest courseRequest){
        return courseService.create(courseRequest);
    }
}
