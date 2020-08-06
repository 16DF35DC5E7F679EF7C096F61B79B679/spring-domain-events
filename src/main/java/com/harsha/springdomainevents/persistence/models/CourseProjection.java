package com.harsha.springdomainevents.persistence.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Data
public class CourseProjection extends BaseProjection{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "course_code")
    String courseCode;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "end_date")
    private Long endDate;

    @Column(name = "credits")
    private Double credits;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH
    })
    @JoinTable(name = "course_student_map",
                joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentProjection> students;

    @OneToMany(mappedBy = "courseProjection")
    private List<AssignmentProjection> assignmentProjections;

    @OneToMany(mappedBy = "courseProjection")
    private List<ClassProjection> classProjections;

    @OneToMany(mappedBy = "courseProjection")
    private List<FeedbackProjection> feedbackProjections;

    public CourseProjection() {

    }
}
