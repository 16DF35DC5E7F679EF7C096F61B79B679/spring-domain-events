package com.harsha.springdomainevents.dtos.response;

import lombok.Data;

@Data
public class StudentResponseDTO {
    private String studentId;
    private String name;
    private String email;
    private String contact;
    private Long dob;
    private String secondaryContact;
    private String fathersName;
    private String mothersName;
    private String fathersContact;
    private String mothersContact;
}
