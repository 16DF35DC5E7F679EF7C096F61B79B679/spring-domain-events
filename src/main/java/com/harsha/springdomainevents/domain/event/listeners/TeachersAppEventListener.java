package com.harsha.springdomainevents.domain.event.listeners;

import com.harsha.springdomainevents.domain.event.events.CourseCreatedEvent;
import com.harsha.springdomainevents.domain.event.events.GradeSubmittedEvent;
import com.harsha.springdomainevents.domain.event.events.TeacherCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TeachersAppEventListener {

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

}

