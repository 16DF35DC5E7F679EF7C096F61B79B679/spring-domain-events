package com.harsha.springdomainevents.controller;

import com.harsha.springdomainevents.domain.teacher.service.TeacherService;
import com.harsha.springdomainevents.dtos.request.AddAddressRequestDTO;
import com.harsha.springdomainevents.dtos.request.CreateTeacherRequestDTO;
import com.harsha.springdomainevents.dtos.response.TeacherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(value = "")
    public ResponseEntity<TeacherResponseDTO> createTeacher(@RequestBody @Valid CreateTeacherRequestDTO createTeacherRequestDTO) {
        return new ResponseEntity<>(teacherService.createTeacher(createTeacherRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/address")
    public ResponseEntity<TeacherResponseDTO> addAddress(@PathVariable String id, @RequestBody @Valid AddAddressRequestDTO addAddressRequestDTO) {
        return new ResponseEntity<>(teacherService.addAddress(id, addAddressRequestDTO), HttpStatus.CREATED);
    }
}
