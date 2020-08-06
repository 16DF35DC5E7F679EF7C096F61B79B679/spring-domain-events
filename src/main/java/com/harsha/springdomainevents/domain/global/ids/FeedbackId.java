package com.harsha.springdomainevents.domain.global.ids;

public class FeedbackId {
    public String feedbackId;

    private FeedbackId(FeedbackIdBuilder builder) {
        this.feedbackId = IdEncoder.encode(builder.toString());
    }

    public static class FeedbackIdBuilder{
        private String courseId;
        private String studentId;
        private Float points;
        private Integer willRecommendThisCourse;


        public FeedbackIdBuilder courseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public FeedbackIdBuilder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public FeedbackIdBuilder points(Float points) {
            this.points = points;
            return this;
        }

        public FeedbackIdBuilder willRecommendThisCourse(Integer willRecommendThisCourse) {
            this.willRecommendThisCourse = willRecommendThisCourse;
            return this;
        }

        public FeedbackId build() {
            return new FeedbackId(this);
        }

        @Override
        public String toString() {
            return "FeedbackIdBuilder{" +
                    "courseId='" + courseId + '\'' +
                    ", studentId='" + studentId + '\'' +
                    ", points=" + points +
                    ", willRecommendThisCourse=" + willRecommendThisCourse +
                    '}';
        }
    }
}
