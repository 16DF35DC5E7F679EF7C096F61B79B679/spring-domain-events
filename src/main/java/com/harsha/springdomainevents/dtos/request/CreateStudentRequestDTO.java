package com.harsha.springdomainevents.dtos.request;

import lombok.Data;

@Data
public class CreateStudentRequestDTO {
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
