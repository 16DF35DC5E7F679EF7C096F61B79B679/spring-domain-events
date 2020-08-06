package com.harsha.springdomainevents.domain.global.ids;

public class ClassId {
    public String classId;

    private ClassId(ClassIdBuilder builder) {
        this.classId = IdEncoder.encode(builder.toString());
    }

    public static class ClassIdBuilder {
        private String courseId;
        private String startEpoch;
        private String endEpoch;


        public ClassIdBuilder courseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public ClassIdBuilder startEpoch(String startEpoch) {
            this.startEpoch = startEpoch;
            return this;
        }

        public ClassIdBuilder endEpoch(String endEpoch) {
            this.endEpoch = endEpoch;
            return this;
        }

        public ClassId build() {
            return new ClassId(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "courseId='" + courseId + '\'' +
                    ", startEpoch='" + startEpoch + '\'' +
                    ", endEpoch='" + endEpoch + '\'' +
                    '}';
        }
    }
}
