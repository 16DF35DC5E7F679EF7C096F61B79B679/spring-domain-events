package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "assignment")
public class AssignmentProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private Long dueDate;

    @Column(name = "total_marks")
    private Float totalMarks;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "course_id")
    private CourseProjection courseProjection;

    @OneToMany(mappedBy = "assignmentProjection")
    private List<SubmissionProjection> submissionProjections;
}
