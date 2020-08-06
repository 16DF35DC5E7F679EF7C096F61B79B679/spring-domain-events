package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @OneToMany(mappedBy = "studentProjection")
    private List<AttendanceProjection> attendanceProjection;

    @OneToMany(mappedBy = "studentProjection")
    private List<GradeProjection> gradeProjections;

    @OneToMany(mappedBy = "studentProjection")
    private List<FeedbackProjection> feedbackProjections;

    @OneToMany(mappedBy = "studentProjection")
    private List<SubmissionProjection> submissionProjections;
}
