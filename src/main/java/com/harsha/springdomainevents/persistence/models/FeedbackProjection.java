package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class FeedbackProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "feedback_id")
    private String feedbackId;

    @Column(name = "points")
    private Float points;

    @Column(name = "max_points")
    private Float maxPoints;

    @Column(name = "description")
    private String description;

    @Column(name = "will_recommend_this_course")
    private Boolean willRecommendThisCourse;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "student_id")
    private String studentId;
}
