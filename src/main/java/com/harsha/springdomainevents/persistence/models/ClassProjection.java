package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "class")
public class ClassProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "course_id")
    private CourseProjection courseProjection;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "class_location_id")
    private ClassLocationProjection classLocationProjection;

    @Column(name = "day")
    private String day;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTIme;

}
