package com.harsha.springdomainevents.dtos.request;

import lombok.Data;

@Data
public class CreateAssignmentRequestDTO {
    private String title;
    private String description;
    private Float totalMarks;
    private Long postedOn;
    private Long dueDate;
    private String courseTitle;
    private String courseDescription;
}
