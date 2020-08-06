package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class AttendanceProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "attendance_id")
    private String attendanceId;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "class_id")
    private String classId;
}
