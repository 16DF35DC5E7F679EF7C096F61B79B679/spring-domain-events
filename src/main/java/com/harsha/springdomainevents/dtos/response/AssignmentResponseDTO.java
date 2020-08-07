package com.harsha.springdomainevents.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignmentResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Float totalMarks;
    private Long postedOn;
    private Long dueDate;
    private String courseTitle;
    private String courseDescription;
    private String assignmentId;
}
