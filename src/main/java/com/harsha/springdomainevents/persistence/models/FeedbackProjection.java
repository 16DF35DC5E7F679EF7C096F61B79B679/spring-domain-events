package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class FeedbackProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "points")
    private Float points;

    @Column(name = "max_points")
    private Float maxPoints;

    @Column(name = "description")
    private String description;

    @Column(name = "will_recommend_this_course")
    private Boolean willRecommendThisCourse;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "course_id")
    private CourseProjection courseProjection;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "student_id")
    private StudentProjection studentProjection;
}
