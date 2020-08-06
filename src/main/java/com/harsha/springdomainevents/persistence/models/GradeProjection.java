package com.harsha.springdomainevents.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "grade")
public class GradeProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "grade")
    private Double grade;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "student_id")
    StudentProjection studentProjection;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "course_id")
    @JsonBackReference
    CourseProjection courseProjection;
}
