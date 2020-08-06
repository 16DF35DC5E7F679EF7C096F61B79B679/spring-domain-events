package com.harsha.springdomainevents.dtos.request;

public class CreateCourseRequestDTO {
    private String teacherEmail;
    private Long startDate;
    private Long endDate;
    private String title;
    private String description;
    private Float credits;
    private String courseCode;

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public CreateCourseRequestDTO setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
        return this;
    }

    public Long getStartDate() {
        return startDate;
    }

    public CreateCourseRequestDTO setStartDate(Long startDate) {
        this.startDate = startDate;
        return this;
    }

    public Long getEndDate() {
        return endDate;
    }

    public CreateCourseRequestDTO setEndDate(Long endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CreateCourseRequestDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateCourseRequestDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Float getCredits() {
        return credits;
    }

    public CreateCourseRequestDTO setCredits(Float credits) {
        this.credits = credits;
        return this;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public CreateCourseRequestDTO setCourseCode(String courseCode) {
        this.courseCode = courseCode;
        return this;
    }
}
