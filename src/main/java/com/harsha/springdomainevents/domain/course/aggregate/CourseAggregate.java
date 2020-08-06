package com.harsha.springdomainevents.domain.course.aggregate;

import com.harsha.springdomainevents.domain.global.ids.CourseId;
import com.harsha.springdomainevents.domain.global.ids.PersonId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseAggregate {
    private final CourseRootEntity courseRootEntity;
    private PersonId teacherId;
    private CourseId courseId;
    private List<PersonId> studentIds;

    private CourseAggregate(CourseAggregateBuilder builder) {
        this.courseRootEntity = new CourseRootEntity(builder.title, builder.description,
                builder.credits, builder.courseStartDate, builder.courseEndDate, builder.courseCode, builder.id);
        this.teacherId = builder.teacherId;
        this.courseId = new CourseId.CourseIdBuilder()
                .teacherId(teacherId.userId)
                .courseTitle(getTitle())
                .courseDescription(getDescription())
                .build();
        if(builder.studentIds!=null){
            this.studentIds = builder.studentIds;
        } else {
            this.studentIds = new ArrayList<>();
        }
    }

    public static class CourseAggregateBuilder {
        private String title;
        private String description;
        private Float credits;
        private Long courseStartDate;
        private Long courseEndDate;
        private String courseCode;
        private PersonId teacherId;

        public CourseAggregateBuilder id(Long id) {
            this.id = id;
            return this;
        }

        private Long id;

        public CourseAggregateBuilder studentIds(List<PersonId> studentIds) {
            this.studentIds = studentIds;
            return this;
        }

        private List<PersonId> studentIds;

        public CourseAggregateBuilder courseStartDate(Long courseStartDate) {
            this.courseStartDate = courseStartDate;
            return this;
        }

        public CourseAggregateBuilder courseEndDate(Long courseEndDate) {
            this.courseEndDate = courseEndDate;
            return this;
        }

        public CourseAggregateBuilder credits(Float credits) {
            this.credits = credits;
            return this;
        }

        public CourseAggregateBuilder title(String title) {
            this.title = title;
            return this;
        }

        public CourseAggregateBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CourseAggregateBuilder courseCode(String courseCode) {
            this.courseCode = courseCode;
            return this;
        }

        public CourseAggregate build() {
            return new CourseAggregate(this);
        }

        public CourseAggregateBuilder teacherId(PersonId teacherId) {
            this.teacherId = teacherId;
            return this;
        }
    }

    public CourseAggregate addStudent(PersonId studentId) {
        if(!this.studentIds.contains(studentId)) {
            this.studentIds.add(studentId);
        }
        return this;
    }

    public String getTitle() {
        return courseRootEntity.getTitle();
    }

    public Float getCredits() {
        return courseRootEntity.getCredits();
    }

    public Long getStartDate() {
        return courseRootEntity.getCourseStartDate();
    }

    public Long getEndDate() {
        return courseRootEntity.getCourseEndDate();
    }

    public String getTeacherId() {
        return teacherId.userId;
    }

    public String getDescription() {
        return courseRootEntity.getDescription();
    }

    public String getCourseCode() {
        return courseRootEntity.getCourseCode();
    }

    public String getCourseId() {
        return this.courseId.courseId;
    }

    public Long getId() {
        return this.courseRootEntity.getId();
    }

    public List<String> getStudentIds() {
        if(this.studentIds==null) {
            return new ArrayList<>();
        }
        return this.studentIds.stream().map(studentId -> studentId.userId).collect(Collectors.toList());
    }
}
