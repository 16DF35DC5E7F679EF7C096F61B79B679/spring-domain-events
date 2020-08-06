package com.harsha.springdomainevents.domain.course.service;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import com.harsha.springdomainevents.domain.event.events.CourseCreatedEvent;
import com.harsha.springdomainevents.domain.global.PersonId;
import com.harsha.springdomainevents.domain.teacher.aggregate.TeacherAggregate;
import com.harsha.springdomainevents.dtos.request.CreateCourseRequestDTO;
import com.harsha.springdomainevents.dtos.request.CreateTeacherRequestDTO;
import com.harsha.springdomainevents.dtos.response.CourseResponseDTO;
import com.harsha.springdomainevents.persistence.dao.CourseDAO;
import com.harsha.springdomainevents.persistence.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CoursesService {

    ApplicationEventPublisher applicationEventPublisher;

    TeacherDAO teacherDAO;

    CourseDAO courseDAO;

    @Autowired
    public CoursesService(TeacherDAO teacherDAO, CourseDAO courseDAO, ApplicationEventPublisher applicationEventPublisher) {
        this.teacherDAO = teacherDAO;
        this.applicationEventPublisher = applicationEventPublisher;
        this.courseDAO = courseDAO;
    }

    @Transactional
    public CourseResponseDTO createCourse(CreateCourseRequestDTO createCourseRequestDTO) {
        CourseAggregate courseAggregate = convertRequestDTOToAggregate(createCourseRequestDTO);
        courseDAO.createCourse(courseAggregate);
        applicationEventPublisher.publishEvent(new CourseCreatedEvent(courseAggregate));
        return createCourseResponseDTO(courseAggregate);
    }

    private CourseAggregate convertRequestDTOToAggregate(CreateCourseRequestDTO createCourseRequestDTO) {
        TeacherAggregate teacherAggregate = teacherDAO.findByEmail(createCourseRequestDTO.getTeacherEmail());
        PersonId teacherId = new PersonId.UserIdBuilder().name(teacherAggregate.getName())
                .email(teacherAggregate.getEmail())
                .dob(teacherAggregate.getDob())
                .contact(teacherAggregate.getContact())
                .build();
        return new CourseAggregate.CourseAggregateBuilder()
                .courseEndDate(createCourseRequestDTO.getEndDate())
                .courseStartDate(createCourseRequestDTO.getStartDate())
                .credits(createCourseRequestDTO.getCredits())
                .title(createCourseRequestDTO.getTitle())
                .description(createCourseRequestDTO.getDescription())
                .courseCode(createCourseRequestDTO.getCourseCode())
                .teacherEmail(createCourseRequestDTO.getTeacherEmail())
                .build();
    }

    private CourseResponseDTO createCourseResponseDTO(CourseAggregate courseAggregate) {
        //TODO
        return new CourseResponseDTO(
                courseAggregate.getTitle(),
                courseAggregate.getDescription(),
                courseAggregate.getTeacherEmail(),
                courseAggregate.getStartDate(),
                courseAggregate.getEndDate(),
                courseAggregate.getCourseCode()
        );
    }
}