package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "submission")
public class SubmissionProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "public_url")
    private String publicUrl;

    @Column(name = "is_downloadable")
    private Integer isDownloadable;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "assignment_id")
    private AssignmentProjection assignmentProjection;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "student_id")
    private StudentProjection studentProjection;

    @OneToOne(mappedBy = "submissionProjection")
    private EvaluationProjection evaluationProjection;
}
