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

    @Column(name = "course_id")
    String courseId;

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

    @Column(name = "teacher_id")
    private String teacherId;

    @ElementCollection
    private List<String> studentIds;

    @ElementCollection
    private List<String> assignmentIds;

    @ElementCollection
    private List<String> classIds;

    @ElementCollection
    private List<String> feedbackIds;

    public CourseProjection() {

    }
}
