package com.harsha.springdomainevents.domain.submission.aggregate;

class SubmissionRootEntity {
    private Long submissionDateEpoch;
    private UploadedObjectVO uploadedObjectVO;
    private EvaluationVO evaluationVO;

    public SubmissionRootEntity(Long submissionDateEpoch, UploadedObjectVO uploadedObjectVO, EvaluationVO evaluationVO) {
        this.submissionDateEpoch = submissionDateEpoch;
        this.uploadedObjectVO = uploadedObjectVO;
        this.evaluationVO = evaluationVO;
    }
}
