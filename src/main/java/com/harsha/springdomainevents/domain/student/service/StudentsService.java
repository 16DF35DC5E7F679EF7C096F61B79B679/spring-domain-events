package com.harsha.springdomainevents.domain.student.service;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import com.harsha.springdomainevents.domain.course.service.CoursesService;
import com.harsha.springdomainevents.domain.event.events.StudentOptedForCourseEvent;
import com.harsha.springdomainevents.domain.student.aggregate.StudentAggregate;
import com.harsha.springdomainevents.dtos.generic.StudentCourseMap;
import com.harsha.springdomainevents.dtos.request.CreateStudentRequestDTO;
import com.harsha.springdomainevents.dtos.response.CourseResponseDTO;
import com.harsha.springdomainevents.dtos.response.StudentResponseDTO;
import com.harsha.springdomainevents.persistence.dao.CourseDAO;
import com.harsha.springdomainevents.persistence.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentsService {

    StudentDAO studentDAO;

    CourseDAO courseDAO;

    CoursesService coursesService;

    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public StudentsService(StudentDAO studentDAO, CourseDAO courseDAO, CoursesService coursesService, ApplicationEventPublisher applicationEventPublisher) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.coursesService = coursesService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public StudentResponseDTO createStudent(CreateStudentRequestDTO createStudentRequestDTO) {
        StudentAggregate studentAggregate = convertRequestDTOToAggregate(createStudentRequestDTO);
        StudentAggregate createdStudentAggregate = studentDAO.createStudent(studentAggregate);
        return convertAggregateToResponseDTO(createdStudentAggregate);
    }

    private StudentAggregate convertRequestDTOToAggregate(CreateStudentRequestDTO createStudentRequestDTO) {
        return new StudentAggregate.StudentAggregateBuilder()
                .name(createStudentRequestDTO.getName())
                .email(createStudentRequestDTO.getEmail())
                .contact(createStudentRequestDTO.getContact())
                .dob(createStudentRequestDTO.getDob())
                .fathersName(createStudentRequestDTO.getFathersName())
                .mothersName(createStudentRequestDTO.getMothersName())
                .fathersContact(createStudentRequestDTO.getFathersContact())
                .mothersContact(createStudentRequestDTO.getMothersContact())
                .build();
    }

    private StudentResponseDTO convertAggregateToResponseDTO(StudentAggregate studentAggregate)  {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setName(studentAggregate.getName());
        studentResponseDTO.setContact(studentAggregate.getContact());
        studentResponseDTO.setEmail(studentAggregate.getEmail());
        studentResponseDTO.setFathersName(studentAggregate.getFathersName());
        studentResponseDTO.setMothersName(studentAggregate.getMothersName());
        studentResponseDTO.setFathersContact(studentAggregate.getFathersContact());
        studentResponseDTO.setMothersContact(studentAggregate.getMothersContact());
        studentResponseDTO.setDob(studentAggregate.getDob());
        studentResponseDTO.setStudentId(studentAggregate.getStudentId());
        return studentResponseDTO;
    }

    @Transactional
    public List<CourseResponseDTO> optCourseForStudent(String studentId, String courseId) {
        CourseAggregate courseAggregate = courseDAO.findByCourseId(courseId);
        StudentAggregate studentAggregate = studentDAO.findByStudentId(studentId);
        StudentAggregate updatedStudentAggregate = studentAggregate.optForCourse(courseAggregate.getCourseId());
        StudentAggregate savedStudent = studentDAO.save(updatedStudentAggregate);
        applicationEventPublisher.publishEvent(new StudentOptedForCourseEvent(new StudentCourseMap(studentId, courseId, System.currentTimeMillis())));
        return savedStudent.getCourseIds().stream()
                .map(courseIdStr -> coursesService.findCourseById(courseIdStr)).collect(Collectors.toList());
    }
}
