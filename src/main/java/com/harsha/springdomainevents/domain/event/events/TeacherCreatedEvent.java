package com.harsha.springdomainevents.domain.event.events;

import com.harsha.springdomainevents.domain.teacher.aggregate.TeacherAggregate;
import org.springframework.context.ApplicationEvent;

public class TeacherCreatedEvent extends ApplicationEvent {
    public TeacherCreatedEvent(TeacherAggregate source) {
        super(source);
    }
}
