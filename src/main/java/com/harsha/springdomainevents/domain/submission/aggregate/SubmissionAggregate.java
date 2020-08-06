package com.harsha.springdomainevents.domain.submission.aggregate;

import com.harsha.springdomainevents.domain.global.AssignmentId;
import com.harsha.springdomainevents.domain.global.PersonId;

public class SubmissionAggregate {
    private AssignmentId assignmentId;
    private PersonId studentId;
    private SubmissionRootEntity submissionRootEntity;

    private SubmissionAggregate(Builder builder) {
        UploadedObjectVO uploadedObjectVO = new UploadedObjectVO(builder.publicUrl, builder.isDownloadable);
        EvaluationVO evaluationVO = new EvaluationVO(builder.points, builder.grade, builder.evaluationComment, builder.evaluationTime);
        this.submissionRootEntity = new SubmissionRootEntity(
                builder.submissionDateEpoch, uploadedObjectVO, evaluationVO
        );
        this.assignmentId = builder.assignmentId;
        this.studentId = builder.studentId;
    }

    public static class Builder{
        private AssignmentId assignmentId;
        private PersonId studentId;
        private Long submissionDateEpoch;
        private String publicUrl;
        private Boolean isDownloadable;
        private Float points;
        private String grade;
        private String evaluationComment;

        public Builder evaluationTime(Long evaluationTime) {
            this.evaluationTime = evaluationTime;
            return this;
        }

        private Long evaluationTime;

        public Builder assignmentId(AssignmentId assignmentId) {
            this.assignmentId = assignmentId;
            return this;
        }

        public Builder studentId(PersonId studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder submissionDateEpoch(Long submissionDateEpoch) {
            this.submissionDateEpoch = submissionDateEpoch;
            return this;
        }

        public Builder publicUrl(String publicUrl) {
            this.publicUrl = publicUrl;
            return this;
        }

        public Builder downloadable(Boolean downloadable) {
            isDownloadable = downloadable;
            return this;
        }

        public SubmissionAggregate build() {
            return new SubmissionAggregate(this);
        }

        public Builder points(Float points) {
            this.points = points;
            return this;
        }

        public Builder grade(String grade) {
            this.grade = grade;
            return this;
        }

        public Builder evaluationComment(String evaluationComment) {
            this.evaluationComment = evaluationComment;
            return this;
        }
    }
}
