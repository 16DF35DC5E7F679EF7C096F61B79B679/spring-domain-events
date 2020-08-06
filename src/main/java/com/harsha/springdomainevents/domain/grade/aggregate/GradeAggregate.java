package com.harsha.springdomainevents.domain.grade.aggregate;

import com.harsha.springdomainevents.domain.global.CourseId;
import com.harsha.springdomainevents.domain.global.PersonId;

public class GradeAggregate {
    private CourseId courseId;
    private PersonId studentId;
    private Float grade;

    private GradeAggregate(Builder builder) {
        this.courseId = builder.courseId;
        this.studentId = builder.studentId;
        this.grade = builder.grade;
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public PersonId getStudentId() {
        return studentId;
    }

    public Float getGrade() {
        return grade;
    }

    public static class Builder {
        private CourseId courseId;
        private PersonId studentId;
        private Float grade;


        public Builder setCourseId(CourseId courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder studentId(PersonId studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder grade(Float grade) {
            this.grade = grade;
            return this;
        }

        public GradeAggregate build() {
            return new GradeAggregate(this);
        }
    }
}