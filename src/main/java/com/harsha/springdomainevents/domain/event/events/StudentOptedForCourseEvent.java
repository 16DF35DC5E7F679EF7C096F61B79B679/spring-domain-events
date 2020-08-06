package com.harsha.springdomainevents.domain.event.events;

import com.harsha.springdomainevents.dtos.generic.StudentCourseMap;
import org.springframework.context.ApplicationEvent;

public class StudentOptedForCourseEvent extends ApplicationEvent {
    private String courseId;
    private String studentId;

    public StudentOptedForCourseEvent(StudentCourseMap source) {
        super(source);
        this.courseId = source.getCourseId();
        this.studentId = source.getStudentId();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStudentId() {
        return studentId;
    }
}
