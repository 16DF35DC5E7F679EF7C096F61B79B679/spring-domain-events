package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "submission")
public class SubmissionProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "submissionId")
    private String submissionId;

    @Column(name = "public_url")
    private String publicUrl;

    @Column(name = "is_downloadable")
    private Integer isDownloadable;

    @Column(name = "assignment_id")
    private String assignmentId;

    @Column(name = "student_id")
    private String studentProjection;

    @Column(name = "evaluation_id")
    private String evaluationId;
}
