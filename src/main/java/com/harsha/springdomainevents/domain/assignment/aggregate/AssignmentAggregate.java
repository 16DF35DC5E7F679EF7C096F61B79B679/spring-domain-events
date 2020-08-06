package com.harsha.springdomainevents.domain.assignment.aggregate;

import com.harsha.springdomainevents.domain.global.ids.AssignmentId;
import com.harsha.springdomainevents.domain.global.ids.CourseId;

public class AssignmentAggregate {

    private final AssignmentRootEntity assignmentRootEntity;
    private final CourseId courseId;
    private final AssignmentId assignmentId;

    private AssignmentAggregate(AssignmentAggregateBuilder assignmentAggregateBuilder) {
        this.assignmentRootEntity = new AssignmentRootEntity(
                assignmentAggregateBuilder.title, assignmentAggregateBuilder.description, assignmentAggregateBuilder.totalMarks,
                assignmentAggregateBuilder.postedOn, assignmentAggregateBuilder.dueDate
        );
        this.courseId = new CourseId.CourseIdBuilder().courseDescription(assignmentAggregateBuilder.courseDescription)
                .courseTitle(assignmentAggregateBuilder.courseTitle).build();
        this.assignmentId = new AssignmentId.AssignmentIdBuilder()
                .courseId(this.courseId.courseId)
                .postedOn(assignmentAggregateBuilder.postedOn)
                .title(assignmentAggregateBuilder.courseTitle)
                .totalMarks(assignmentAggregateBuilder.totalMarks)
                .build();
    }

    public static class AssignmentAggregateBuilder {
        private String title;
        private String description;
        private Float totalMarks;
        private Long postedOn;
        private Long dueDate;
        private String courseTitle;
        private String courseDescription;

        public AssignmentAggregateBuilder title(String title) {
            this.title = title;
            return this;
        }

        public AssignmentAggregateBuilder description(String description) {
            this.description = description;
            return this;
        }

        public AssignmentAggregateBuilder totalMarks(Float totalMarks) {
            this.totalMarks = totalMarks;
            return this;
        }

        public AssignmentAggregateBuilder postedOn(Long postedOn) {
            this.postedOn = postedOn;
            return this;
        }

        public AssignmentAggregateBuilder dueData(Long dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public AssignmentAggregateBuilder courseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
            return this;
        }

        public AssignmentAggregateBuilder courseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public AssignmentAggregate build() {
            return new AssignmentAggregate(this);
        }
    }
}
