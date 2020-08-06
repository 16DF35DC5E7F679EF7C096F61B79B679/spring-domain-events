package com.harsha.springdomainevents.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherResponseDTO {
    String teacherId;
    String name;
    String email;
    String contact;
    String secondaryContact;
    String dob;
}
