package com.harsha.springdomainevents.domain.global;

public class AssignmentId {
    public String assignmentId;

    private AssignmentId(AssignmentIdBuilder builder) {
        this.assignmentId = IdEncoder.encode(builder.toString());
    }

    public static class AssignmentIdBuilder {
        private String title;
        private String description;
        private Float totalMarks;
        private Long postedOn;
        private Long dueDate;

        public AssignmentIdBuilder title(String title) {
            this.title = title;
            return this;
        }

        public AssignmentIdBuilder description(String description) {
            this.description = description;
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

        public AssignmentIdBuilder dueDate(Long dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public AssignmentId build() {
            return new AssignmentId(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", totalMarks=" + totalMarks +
                    ", postedOn=" + postedOn +
                    ", dueDate=" + dueDate +
                    '}';
        }
    }
}
