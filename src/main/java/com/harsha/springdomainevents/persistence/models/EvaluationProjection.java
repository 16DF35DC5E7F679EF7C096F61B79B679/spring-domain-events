package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "evaluation")
public class EvaluationProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "submission_id")
    SubmissionProjection submissionProjection;

}
