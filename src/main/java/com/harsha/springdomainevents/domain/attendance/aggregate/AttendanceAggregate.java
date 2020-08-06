package com.harsha.springdomainevents.domain.attendance.aggregate;

import com.harsha.springdomainevents.domain.global.ClassId;
import com.harsha.springdomainevents.domain.global.PersonId;

public class AttendanceAggregate {
    private PersonId studentId;
    private ClassId classId;
    private Boolean isPresent;

    private AttendanceAggregate(AttendanceAggregateBuilder builder) {
        this.studentId = builder.studentId;
        this.classId = builder.classId;
        this.isPresent = builder.isPresent;
    }

    public static class AttendanceAggregateBuilder {
        private PersonId studentId;
        private ClassId classId;
        private Boolean isPresent;

        public AttendanceAggregateBuilder userId(PersonId userId) {
            this.studentId = userId;
            return this;
        }

        public AttendanceAggregateBuilder classId(ClassId classId) {
            this.classId = classId;
            return this;
        }

        public AttendanceAggregateBuilder present(Boolean present) {
            isPresent = present;
            return this;
        }

        public AttendanceAggregate build() {
            return new AttendanceAggregate(this);
        }
    }
}
