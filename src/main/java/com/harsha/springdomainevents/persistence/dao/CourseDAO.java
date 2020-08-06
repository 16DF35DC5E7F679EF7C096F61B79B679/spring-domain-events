package com.harsha.springdomainevents.persistence.dao;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import com.harsha.springdomainevents.persistence.models.CourseProjection;
import com.harsha.springdomainevents.persistence.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CourseDAO {

    private CourseRepository courseRepository;

    @Autowired
    public CourseDAO(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseAggregate createCourse(CourseAggregate courseAggregate) {
        CourseProjection courseProjection = convertAggregateToProjection(courseAggregate);
        CourseProjection savedCourseProjection = courseRepository.save(courseProjection);
        return courseAggregate;
    }

    private CourseProjection convertAggregateToProjection(CourseAggregate courseAggregate) {

        CourseProjection courseProjection = new CourseProjection();
        courseProjection.setCourseCode(courseAggregate.getCourseCode());
        courseProjection.setTitle(courseAggregate.getTitle());
        courseProjection.setCredits(courseAggregate.getCredits().doubleValue());
        courseProjection.setDescription(courseAggregate.getDescription());
        courseProjection.setStartDate(courseAggregate.getStartDate());
        courseProjection.setEndDate(courseAggregate.getEndDate());
        courseProjection.setAssignmentProjections(new ArrayList<>());
        courseProjection.setClassProjections(new ArrayList<>());
        courseProjection.setFeedbackProjections(new ArrayList<>());
        courseProjection.setStudents(new ArrayList<>());
        return courseProjection;
    }
}
