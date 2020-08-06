package com.harsha.springdomainevents.persistence.dao;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import com.harsha.springdomainevents.domain.global.ids.PersonId;
import com.harsha.springdomainevents.persistence.models.CourseProjection;
import com.harsha.springdomainevents.persistence.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

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
        return convertProjectionToAggregate(savedCourseProjection);
    }

    public CourseAggregate findByCode(String courseCode) {
        Optional<CourseProjection> courseProjection = courseRepository.findByCourseCode(courseCode);
        if(courseProjection.isPresent()) {
            return convertProjectionToAggregate(courseProjection.get());
        }
        return null;
    }

    public CourseAggregate saveCourse(CourseAggregate courseAggregate) {
        CourseProjection courseProjection = convertAggregateToProjection(courseAggregate);
        CourseProjection savedCourseProjection = courseRepository.save(courseProjection);
        return convertProjectionToAggregate(savedCourseProjection);
    }

    public CourseAggregate findByCourseId(String courseId) {
        Optional<CourseProjection> courseProjection = courseRepository.findByCourseId(courseId);
        if(courseProjection.isPresent()) {
            return convertProjectionToAggregate(courseProjection.get());
        }
        return null;
    }

    private CourseProjection convertAggregateToProjection(CourseAggregate courseAggregate) {
        CourseProjection courseProjection = new CourseProjection();
        courseProjection.setId(courseAggregate.getId());
        courseProjection.setCourseCode(courseAggregate.getCourseCode());
        courseProjection.setTitle(courseAggregate.getTitle());
        courseProjection.setCredits(courseAggregate.getCredits().doubleValue());
        courseProjection.setDescription(courseAggregate.getDescription());
        courseProjection.setStartDate(courseAggregate.getStartDate());
        courseProjection.setEndDate(courseAggregate.getEndDate());
        courseProjection.setCourseId(courseAggregate.getCourseId());
        courseProjection.setTeacherId(courseAggregate.getTeacherId());
        courseProjection.setStudentIds(courseAggregate.getStudentIds());
        return courseProjection;
    }

    private CourseAggregate convertProjectionToAggregate(CourseProjection courseProjection) {
        CourseAggregate.CourseAggregateBuilder courseAggregateBuilder = new CourseAggregate.CourseAggregateBuilder()
                .id(courseProjection.getId())
                .title(courseProjection.getTitle())
                .description(courseProjection.getDescription())
                .credits(courseProjection.getCredits().floatValue())
                .courseStartDate(courseProjection.getStartDate())
                .courseEndDate(courseProjection.getEndDate())
                .courseCode(courseProjection.getCourseCode())
                .teacherId(new PersonId(courseProjection.getTeacherId()));
        if(courseProjection.getStudentIds()!=null) {
            courseAggregateBuilder.studentIds(courseProjection.getStudentIds().stream()
            .map(PersonId::new).collect(Collectors.toList()));
        }
        return courseAggregateBuilder.build();
    }
}
