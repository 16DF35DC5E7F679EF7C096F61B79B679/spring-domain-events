package com.harsha.springdomainevents.domain.submission.aggregate;

class EvaluationVO {
    private Float points;
    private String grade;
    private String comment;
    private Long timestamp;

    public EvaluationVO(Float points, String grade, String comment, Long timestamp) {
        this.points = points;
        this.grade = grade;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public Float getPoints() {
        return points;
    }

    public String getGrade() {
        return grade;
    }

    public String getComment() {
        return comment;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
