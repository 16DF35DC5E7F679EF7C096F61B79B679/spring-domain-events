package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "evaluation")
public class EvaluationProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "evaluation_id")
    private String evaluationId;

    @Column(name = "submission_id")
    private String submissionId;

}
