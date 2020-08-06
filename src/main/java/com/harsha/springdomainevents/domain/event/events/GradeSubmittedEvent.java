package com.harsha.springdomainevents.domain.event.events;

import com.harsha.springdomainevents.domain.grade.aggregate.GradeAggregate;
import org.springframework.context.ApplicationEvent;

public class GradeSubmittedEvent extends ApplicationEvent {
    private String courseId;
    private String studentId;
    private float grade;

    public GradeSubmittedEvent(GradeAggregate source) {
        super(source);
        this.courseId = source.getCourseId().courseId;
        this.studentId = source.getStudentId().userId;
        this.grade = source.getGrade();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public float getGrade() {
        return grade;
    }
}
