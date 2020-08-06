package com.harsha.springdomainevents.domain.global;

public class CourseId {

    public String courseId;

    private CourseId(CourseIdBuilder builder) {
        this.courseId = IdEncoder.encode(builder.toString());
    }

    public static class CourseIdBuilder {
        private String courseDescription;
        private String courseTitle;
        private String teacherEmail;


        public CourseIdBuilder courseDescription(String courseDescription) {
            this.courseDescription = courseDescription;
            return this;
        }

        public CourseIdBuilder courseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
            return this;
        }

        public CourseIdBuilder teacherEmail(String teacherEmail) {
            this.teacherEmail = teacherEmail;
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
                    ", teacherEmail='" + teacherEmail + '\'' +
                    '}';
        }
    }
}
