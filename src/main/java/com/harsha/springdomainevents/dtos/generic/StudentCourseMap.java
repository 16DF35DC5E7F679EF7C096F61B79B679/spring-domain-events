package com.harsha.springdomainevents.dtos.generic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentCourseMap {
    private String studentId;
    private String courseId;
    private Long timestamp;
}
