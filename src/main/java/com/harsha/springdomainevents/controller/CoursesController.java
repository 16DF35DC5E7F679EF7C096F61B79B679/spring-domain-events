package com.harsha.springdomainevents.controller;

import com.harsha.springdomainevents.domain.course.service.CoursesService;
import com.harsha.springdomainevents.dtos.request.CreateCourseRequestDTO;
import com.harsha.springdomainevents.dtos.response.CourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Validator;

@RestController
@RequestMapping("/course")
public class CoursesController {

    CoursesService coursesService;

    Validator validator;

    @Autowired
    public CoursesController(CoursesService coursesService, Validator validator) {
        this.coursesService = coursesService;
        this.validator = validator;
    }

    @PostMapping(value = "")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CreateCourseRequestDTO requestDTO) {
        validator.validate(requestDTO, CreateCourseRequestDTO.class);
        return new ResponseEntity<>(coursesService.createCourse(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
