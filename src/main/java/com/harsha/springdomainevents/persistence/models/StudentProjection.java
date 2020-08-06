package com.harsha.springdomainevents.persistence.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Data
public class StudentProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "contact")
    private String contact;

    @Column(name = "fathers_name")
    private String fathersName;

    @Column(name = "mothers_name")
    private String mothersName;

    @Column(name = "fathers_contact")
    private String fathersContact;

    @Column(name = "mothers_contact")
    private String mothersContact;

    @Column(name = "overall_grade")
    private Double overallGrade;

    @Column(name = "total_credits")
    private Double totalCredits;

    @ElementCollection
    private List<String> courseIds;

    @ElementCollection
    private List<String> attendanceIds;

    @ElementCollection
    private List<String> gradeIds;

    @ElementCollection
    private List<String> feedbackIds;

    @ElementCollection
    private List<String> submissionIds;
}
