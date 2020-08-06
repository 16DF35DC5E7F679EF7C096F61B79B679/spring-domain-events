package com.harsha.springdomainevents.domain.classOfCourse;

import com.harsha.springdomainevents.domain.global.ids.CourseId;

public class ClassAggregate {
    private CourseId courseId;
    private ClassScheduleVO classScheduleVO;
    private ClassLocationVO classLocationVO;


    private ClassAggregate(ClassAggregateBuilder builder) {
        this.courseId = builder.courseId;
        this.classScheduleVO = new ClassScheduleVO().addClassSchedule(
                new DailyClassScheduleVO(true, builder.startTime, builder.endTime, builder.day)
        );
        this.classLocationVO = new ClassLocationVO(builder.hallNumber, builder.buildingNumber);
    }

    public static class ClassAggregateBuilder {
        private CourseId courseId;
        private String hallNumber;
        private String buildingNumber;
        private Long startTime;
        private Long endTime;
        private String day;

        public ClassAggregateBuilder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public ClassAggregateBuilder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public ClassAggregateBuilder day(String day) {
            this.day = day;
            return this;
        }

        public ClassAggregateBuilder hallNumber(String hallNumber) {
            this.hallNumber = hallNumber;
            return this;
        }

        public ClassAggregateBuilder buildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
            return this;
        }

        public ClassAggregateBuilder courseId(CourseId courseId) {
            this.courseId = courseId;
            return this;
        }

        public ClassAggregate build() {
            return new ClassAggregate(this);
        }
    }
}
