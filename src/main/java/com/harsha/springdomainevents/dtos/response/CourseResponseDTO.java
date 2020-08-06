package com.harsha.springdomainevents.dtos.response;

public class CourseResponseDTO {

    String title;
    String description;
    String teacherId;
    String courseCode;
    Long startDate;
    Long endDate;
    String courseId;

    public CourseResponseDTO(String title, String description, String teacherId, Long startDate, Long endDate, String courseCode, String courseId) {
        this.title = title;
        this.description = description;
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseId = courseId;
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTeacherId() {
        return teacherId;
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

    public String getCourseId() {
        return courseId;
    }
}
