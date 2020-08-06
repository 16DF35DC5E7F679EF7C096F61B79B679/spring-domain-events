package com.harsha.springdomainevents.domain.assignment.aggregate;

class AssignmentRootEntity {

    private String title;
    private String description;
    private Float totalMarks;
    private Long postedOn;
    private Long dueDate;

    AssignmentRootEntity(String title, String description, Float totalMarks, Long postedOn, Long dueDate) {
        this.title = title;
        this.description = description;
        this.totalMarks = totalMarks;
        this.postedOn = postedOn;
        this.dueDate = dueDate;
    }
}
