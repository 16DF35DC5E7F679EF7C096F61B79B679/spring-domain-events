package com.harsha.springdomainevents.domain.event.events;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import org.springframework.context.ApplicationEvent;

public class CourseCreatedEvent extends ApplicationEvent {

    private String courseId;
    private String courseName;
    private Float credits;
    private Long startDate;
    private Long endDate;
    private String teacherEmail;

    public CourseCreatedEvent(CourseAggregate source) {
        super(source);
        this.courseId = source.getCourseId().courseId;
        this.courseName = source.getTitle();
        this.credits = source.getCredits();
        this.startDate = source.getStartDate();
        this.endDate = source.getEndDate();
        this.teacherEmail = source.getTeacherEmail();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Float getCredits() {
        return credits;
    }

    public Long getStartDate() {
        return startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    @Override
    public String toString() {
        return "CourseCreatedEvent{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teacherEmail='" + teacherEmail + '\'' +
                '}';
    }
}
