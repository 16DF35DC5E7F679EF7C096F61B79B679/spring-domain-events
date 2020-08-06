package com.harsha.springdomainevents.domain.course.aggregate;

import com.harsha.springdomainevents.domain.global.CourseId;
import com.harsha.springdomainevents.domain.global.PersonId;

public class CourseAggregate {
    private final CourseRootEntity courseRootEntity;
    private String teacherEmail;

    private CourseAggregate(CourseAggregateBuilder builder) {
        this.courseRootEntity = new CourseRootEntity(builder.title, builder.description,
                builder.credits, builder.courseStartDate, builder.courseEndDate, builder.courseCode);
        this.teacherEmail = builder.teacherEmail;
    }

    public static class CourseAggregateBuilder {
        private String title;
        private String description;
        private Float credits;
        private Long courseStartDate;
        private Long courseEndDate;
        private String courseCode;
        private String teacherEmail;

        public CourseAggregateBuilder courseStartDate(Long courseStartDate) {
            this.courseStartDate = courseStartDate;
            return this;
        }

        public CourseAggregateBuilder courseEndDate(Long courseEndDate) {
            this.courseEndDate = courseEndDate;
            return this;
        }

        public CourseAggregateBuilder credits(Float credits) {
            this.credits = credits;
            return this;
        }

        public CourseAggregateBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CourseAggregateBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CourseAggregateBuilder courseCode(String courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public CourseAggregate build() {
            return new CourseAggregate(this);
        }

        public CourseAggregateBuilder teacherEmail(String teacherEmail) {
            this.teacherEmail = teacherEmail;
            return this;
        }
    }

    public String getTitle() {
        return courseRootEntity.getTitle();
    }

    public Float getCredits() {
        return courseRootEntity.getCredits();
    }

    public Long getStartDate() {
        return courseRootEntity.getCourseStartDate();
    }

    public Long getEndDate() {
        return courseRootEntity.getCourseEndDate();
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public String getDescription() {
        return courseRootEntity.getDescription();
    }

    public String getCourseCode() {
        return courseRootEntity.getCourseCode();
    }

    public CourseId getCourseId() {
        return new CourseId.CourseIdBuilder()
                .teacherEmail(teacherEmail)
                .courseTitle(getTitle())
                .courseDescription(getDescription())
                .build();

    }
}
