package com.harsha.springdomainevents.domain.global.ids;

public class AssignmentId {
    public String assignmentId;

    private AssignmentId(AssignmentIdBuilder builder) {
        this.assignmentId = IdEncoder.encode(builder.toString());
    }

    public AssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public static class AssignmentIdBuilder {
        private String title;
        private String courseId;
        private Float totalMarks;
        private Long postedOn;

        public AssignmentIdBuilder title(String title) {
            this.title = title;
            return this;
        }

        public AssignmentIdBuilder courseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public AssignmentIdBuilder totalMarks(Float totalMarks) {
            this.totalMarks = totalMarks;
            return this;
        }

        public AssignmentIdBuilder postedOn(Long postedOn) {
            this.postedOn = postedOn;
            return this;
        }

        public AssignmentId build() {
            return new AssignmentId(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "title='" + title + '\'' +
                    ", courseId='" + courseId + '\'' +
                    ", totalMarks=" + totalMarks +
                    ", postedOn=" + postedOn +
                    '}';
        }
    }
}
