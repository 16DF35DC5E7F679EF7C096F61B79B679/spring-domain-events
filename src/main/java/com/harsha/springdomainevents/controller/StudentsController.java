package com.harsha.springdomainevents.controller;

import com.harsha.springdomainevents.domain.student.service.StudentsService;
import com.harsha.springdomainevents.dtos.request.CreateStudentRequestDTO;
import com.harsha.springdomainevents.dtos.response.CourseResponseDTO;
import com.harsha.springdomainevents.dtos.response.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsController {

    private StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping(value = "")
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody @Valid CreateStudentRequestDTO createStudentRequestDTO) {
        return new ResponseEntity<>(studentsService.createStudent(createStudentRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/{studentId}/course/{courseId}")
    public ResponseEntity<List<CourseResponseDTO>> optCourse(@PathVariable String studentId, @PathVariable String courseId) {
        return new ResponseEntity<>(studentsService.optCourseForStudent(studentId, courseId), HttpStatus.CREATED);
    }


}
