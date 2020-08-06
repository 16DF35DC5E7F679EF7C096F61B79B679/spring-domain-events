package com.harsha.springdomainevents.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "grade")
public class GradeProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "grade_id")
    private String gradeId;

    @Column(name = "grade")
    private Double grade;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "course_id")
    private String courseId;
}
