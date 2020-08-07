package com.harsha.springdomainevents.domain.course.service;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import com.harsha.springdomainevents.domain.event.events.CourseCreatedEvent;
import com.harsha.springdomainevents.domain.global.ids.PersonId;
import com.harsha.springdomainevents.domain.teacher.aggregate.TeacherAggregate;
import com.harsha.springdomainevents.dtos.request.CreateAssignmentRequestDTO;
import com.harsha.springdomainevents.dtos.request.CreateCourseRequestDTO;
import com.harsha.springdomainevents.dtos.response.AssignmentResponseDTO;
import com.harsha.springdomainevents.dtos.response.CourseResponseDTO;
import com.harsha.springdomainevents.dtos.response.StudentResponseDTO;
import com.harsha.springdomainevents.persistence.dao.CourseDAO;
import com.harsha.springdomainevents.persistence.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoursesService {

    ApplicationEventPublisher applicationEventPublisher;

    CourseDAO courseDAO;

    TeacherDAO teacherDAO;

    @Autowired
    public CoursesService(TeacherDAO teacherDAO, CourseDAO courseDAO, ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
    }

    @Transactional
    public CourseResponseDTO createCourse(CreateCourseRequestDTO createCourseRequestDTO) {
        CourseAggregate courseAggregate = convertRequestDTOToAggregate(createCourseRequestDTO);
        courseDAO.createCourse(courseAggregate);
        applicationEventPublisher.publishEvent(new CourseCreatedEvent(courseAggregate));
        return createCourseResponseDTO(courseAggregate);
    }

    @Transactional
    public CourseResponseDTO findCourseById(String courseId) {
        CourseAggregate courseAggregate = courseDAO.findByCourseId(courseId);
        return createCourseResponseDTO(courseAggregate);
    }

    private CourseAggregate convertRequestDTOToAggregate(CreateCourseRequestDTO createCourseRequestDTO) {
        TeacherAggregate teacherAggregate = teacherDAO.findByTeacherId(createCourseRequestDTO.getTeacherId());
        return new CourseAggregate.CourseAggregateBuilder()
                .courseEndDate(createCourseRequestDTO.getEndDate())
                .courseStartDate(createCourseRequestDTO.getStartDate())
                .credits(createCourseRequestDTO.getCredits())
                .title(createCourseRequestDTO.getTitle())
                .description(createCourseRequestDTO.getDescription())
                .courseCode(createCourseRequestDTO.getCourseCode())
                .teacherId(new PersonId(teacherAggregate.getTeacherId()))
                .build();
    }

    private CourseResponseDTO createCourseResponseDTO(CourseAggregate courseAggregate) {
        //TODO
        return new CourseResponseDTO(
                courseAggregate.getTitle(),
                courseAggregate.getDescription(),
                courseAggregate.getTeacherId(),
                courseAggregate.getStartDate(),
                courseAggregate.getEndDate(),
                courseAggregate.getCourseCode(),
                courseAggregate.getCourseId()
        );
    }

    public List<String> getStudentsForCourse(String courseId) {
        CourseAggregate courseAggregate = courseDAO.findByCourseId(courseId);
        if(courseAggregate.getStudentIds()!=null) {
            return courseAggregate.getStudentIds();
        }
        return new ArrayList<>();
    }

    public AssignmentResponseDTO addAssignment(String id, CreateAssignmentRequestDTO createAssignmentRequestDTO) {
        return null;
    }
}