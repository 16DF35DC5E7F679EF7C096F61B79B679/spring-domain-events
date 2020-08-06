package com.harsha.springdomainevents.domain.event.listeners;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import com.harsha.springdomainevents.domain.course.service.CoursesService;
import com.harsha.springdomainevents.domain.event.events.CourseCreatedEvent;
import com.harsha.springdomainevents.domain.event.events.GradeSubmittedEvent;
import com.harsha.springdomainevents.domain.event.events.StudentOptedForCourseEvent;
import com.harsha.springdomainevents.domain.event.events.TeacherCreatedEvent;
import com.harsha.springdomainevents.domain.global.ids.PersonId;
import com.harsha.springdomainevents.dtos.response.CourseResponseDTO;
import com.harsha.springdomainevents.persistence.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TeachersAppEventListener {

    @Autowired
    CourseDAO courseDAO;

    @EventListener
    public void handleCourseCreatedEvent(CourseCreatedEvent courseCreatedEvent) {
        System.out.println("Course created event has been published" + courseCreatedEvent.toString());
    }

    @EventListener
    public void handleGradeSubmittedEvent(GradeSubmittedEvent gradeSubmittedEvent) {
        System.out.println("Grade submitted event has been published "+ gradeSubmittedEvent.toString());
    }

    @EventListener
    public void handleTeacherCreatedEvent(TeacherCreatedEvent teacherCreatedEvent) {
        System.out.println("Teacher created event has been published " + teacherCreatedEvent.toString());
    }

    @EventListener
    public void handleStudentOptedForCourse(StudentOptedForCourseEvent studentOptedForCourseEvent) {
        System.out.println("Student opted for course event has been published " + studentOptedForCourseEvent.toString());
        CourseAggregate courseAggregate = courseDAO.findByCourseId(studentOptedForCourseEvent.getCourseId());
        CourseAggregate savedCourseAggregate = courseAggregate.addStudent(new PersonId(studentOptedForCourseEvent.getStudentId()));
        courseDAO.saveCourse(savedCourseAggregate);
    }

}

