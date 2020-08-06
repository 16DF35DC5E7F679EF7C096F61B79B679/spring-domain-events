package com.harsha.springdomainevents.domain.classOfCourse;

import java.util.ArrayList;
import java.util.List;

class ClassScheduleVO {
    private List<DailyClassScheduleVO> dailyClassSchedules = new ArrayList<>();

    ClassScheduleVO addClassSchedule(DailyClassScheduleVO dailyClassScheduleVO) {
        if(dailyClassSchedules.size() == 7) {
            System.out.println("Schedules already filled up ");
            return this;
        }
        this.dailyClassSchedules.add(dailyClassScheduleVO);
        return this;
    }
}
