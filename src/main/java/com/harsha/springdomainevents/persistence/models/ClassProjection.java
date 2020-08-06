package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class ClassProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "class_id")
    private String classId;

    @Column(name = "course_id")
    private String courseId;

    @Column(name = "class_location_id")
    private String classLocationId;

    @Column(name = "day")
    private String day;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTIme;

}
