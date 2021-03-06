package com.harsha.springdomainevents.domain.course.aggregate;

class CourseRootEntity {
    private Long id;
    private String title;
    private String description;
    private Float credits;
    private Long courseStartDate;
    private Long courseEndDate;
    private String courseCode;

    CourseRootEntity(String title, String description, Float credits, Long courseStartDate, Long courseEndDate, String courseCode, Long id) {
        this.title = title;
        this.description = description;
        this.credits = credits;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.courseCode = courseCode;
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    String getDescription() {
        return description;
    }

    Float getCredits() {
        return credits;
    }

    Long getCourseStartDate() {
        return courseStartDate;
    }

    Long getCourseEndDate() {
        return courseEndDate;
    }

    String getCourseCode() {
        return courseCode;
    }

    Long getId() {
        return id;
    }
}
