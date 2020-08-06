package com.harsha.springdomainevents.dtos.request;

import lombok.Data;

@Data
public class CreateTeacherRequestDTO {
    String name;
    String email;
    String contact;
    String secondaryContact;
    Long dob;
}
