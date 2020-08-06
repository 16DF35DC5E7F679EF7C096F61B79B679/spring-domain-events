package com.harsha.springdomainevents.domain.global.ids;

public class CourseId {

    public String courseId;

    private CourseId(CourseIdBuilder builder) {
        this.courseId = IdEncoder.encode(builder.toString());
    }

    public CourseId(String courseId) {
        this.courseId = courseId;
    }

    public static class CourseIdBuilder {
        private String courseDescription;
        private String courseTitle;
        private String teacherId;


        public CourseIdBuilder courseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public CourseIdBuilder courseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
            return this;
        }

        public CourseIdBuilder teacherId(String teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        public CourseId build() {
            return new CourseId(this);
        }


        @Override
        public String toString() {
            return "Builder{" +
                    "courseDescription='" + courseDescription + '\'' +
                    ", courseTitle='" + courseTitle + '\'' +
                    ", teacherId'" + teacherId + '\'' +
                    '}';
        }
    }
}
