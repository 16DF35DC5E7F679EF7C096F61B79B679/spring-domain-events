package com.harsha.springdomainevents.domain.classOfCourse;

class DailyClassScheduleVO {
    private Boolean happens;
    private String day;
    private Long startTimeOffset;
    private Long endTimeOffset;

    DailyClassScheduleVO(Boolean happens, Long startTimeOffset, Long endTimeOffset, String day) {
        this.happens = happens;
        this.startTimeOffset = startTimeOffset;
        this.endTimeOffset = endTimeOffset;
        this.day = day;
    }

    public Boolean getHappens() {
        return happens;
    }

    public Long getStartTimeOffset() {
        return startTimeOffset;
    }

    public Long getEndTimeOffset() {
        return endTimeOffset;
    }

    public String getDay() {
        return this.day;
    }
}
