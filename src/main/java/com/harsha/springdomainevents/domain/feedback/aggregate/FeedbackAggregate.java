package com.harsha.springdomainevents.domain.feedback.aggregate;

import com.harsha.springdomainevents.domain.global.ids.CourseId;
import com.harsha.springdomainevents.domain.global.ids.FeedbackId;
import com.harsha.springdomainevents.domain.global.ids.PersonId;

public class FeedbackAggregate {
    private FeedbackId feedbackId;
    private CourseId courseId;
    private PersonId studentId;
    private Float points;
    private Float maxAllowedPoints;
    private String description;
    private Boolean willRecommendThisCourse;

    private FeedbackAggregate(FeedbackAggregateBuilder builder) {
        this.courseId = builder.courseId;
        this.studentId = builder.studentId;
        this.points = builder.points;
        this.maxAllowedPoints = builder.maxAllowedPoints;
        this.description = builder.description;
        this.willRecommendThisCourse = builder.willRecommendThisCourse;
    }

    public static class FeedbackAggregateBuilder {
        private CourseId courseId;
        private PersonId studentId;
        private Float points;
        private Float maxAllowedPoints;
        private String description;
        private Boolean willRecommendThisCourse;


        public FeedbackAggregateBuilder courseId(CourseId courseId) {
            this.courseId = courseId;
            return this;
        }

        public FeedbackAggregateBuilder studentId(PersonId studentId) {
            this.studentId = studentId;
            return this;
        }

        public FeedbackAggregate build() {
            return new FeedbackAggregate(this);
        }

        public FeedbackAggregateBuilder points(Float points) {
            this.points = points;
            return this;
        }

        public FeedbackAggregateBuilder maxAllowedPoints(Float maxAllowedPoints) {
            this.maxAllowedPoints = maxAllowedPoints;
            return this;
        }

        public FeedbackAggregateBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FeedbackAggregateBuilder willRecommendThisCourse(Boolean willRecommendThisCourse) {
            this.willRecommendThisCourse = willRecommendThisCourse;
            return this;
        }
    }
}
