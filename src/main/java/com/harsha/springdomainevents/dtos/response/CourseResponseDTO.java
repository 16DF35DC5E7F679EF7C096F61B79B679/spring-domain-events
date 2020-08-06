package com.harsha.springdomainevents.dtos.response;

public class CourseResponseDTO {

    String title;
    String description;
    String teacherEmail;
    String courseCode;
    Long startDate;
    Long endDate;

    public CourseResponseDTO(String title, String description, String teacherEmail, Long startDate, Long endDate, String courseCode) {
        this.title = title;
        this.description = description;
        this.teacherEmail = teacherEmail;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public Long getStartDate() {
        return startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public String getCourseCode() {
        return courseCode;
    }
}
