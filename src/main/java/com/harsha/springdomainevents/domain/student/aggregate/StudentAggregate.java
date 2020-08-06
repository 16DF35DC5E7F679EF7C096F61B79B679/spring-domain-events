package com.harsha.springdomainevents.domain.student.aggregate;

import com.harsha.springdomainevents.domain.course.aggregate.CourseAggregate;
import com.harsha.springdomainevents.domain.global.ids.CourseId;
import com.harsha.springdomainevents.domain.global.ids.PersonId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAggregate {
    private StudentRootEntity studentRootEntity;
    private PersonId studentId;
    private List<CourseId> courseIds;

    private StudentAggregate(StudentAggregateBuilder builder) {
        BasicInfoVO basicInfoVO = new BasicInfoVO(
                builder.name, builder.contact, builder.email, builder.fathersName, builder.mothersName,
                builder.fathersContact, builder.mothersContact, builder.dob
        );

        AcademicInfoVO academicInfoVO = new AcademicInfoVO(builder.overallGrade, builder.totalCredits);
        this.studentRootEntity = new StudentRootEntity(builder.id, basicInfoVO, academicInfoVO);
        if(builder.studentId!=null) {
            this.studentId = builder.studentId;
        } else {
            this.studentId = new PersonId.UserIdBuilder()
                    .name(builder.name)
                    .email(builder.email)
                    .contact(builder.contact)
                    .dob(builder.dob)
                    .build();
        }
        if(builder.courseIds!=null) {
            this.courseIds = builder.courseIds;
        } else {
            this.courseIds = new ArrayList<>();
        }
    }

    public StudentAggregate optForCourse(String courseId) {
        this.courseIds.add(new CourseId(courseId));
        return this;
    }

    public static class StudentAggregateBuilder {
        private String name;
        private String contact;
        private String email;
        private Long dob;
        private String fathersName;
        private String mothersName;
        private String fathersContact;
        private String mothersContact;
        private Double overallGrade;
        private Double totalCredits;
        private Long id;
        private PersonId studentId;

        public StudentAggregateBuilder courseIds(List<CourseId> courseIds) {
            this.courseIds = courseIds;
            return this;
        }

        public StudentAggregateBuilder studentId(PersonId studentId){
            this.studentId = studentId;
            return this;
        }

        public StudentAggregateBuilder id(Long id) {
            this.id = id;
            return this;
        }

        private List<CourseId> courseIds;

        public StudentAggregateBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentAggregateBuilder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public StudentAggregateBuilder email(String email) {
            this.email = email;
            return this;
        }

        public StudentAggregateBuilder dob(Long dob) {
            this.dob = dob;
            return this;
        }

        public StudentAggregateBuilder fathersName(String fathersName) {
            this.fathersName = fathersName;
            return this;
        }

        public StudentAggregateBuilder mothersName(String mothersName) {
            this.mothersName = mothersName;
            return this;
        }

        public StudentAggregateBuilder fathersContact(String fathersContact) {
            this.fathersContact = fathersContact;
            return this;
        }

        public StudentAggregateBuilder mothersContact(String mothersContact) {
            this.mothersContact = mothersContact;
            return this;
        }

        public StudentAggregateBuilder overallGrade(Double overallGrade) {
            this.overallGrade = overallGrade;
            return this;
        }

        public StudentAggregateBuilder totalCredits(Double totalCredits) {
            this.totalCredits = totalCredits;
            return this;
        }

        public StudentAggregate build() {
            return new StudentAggregate(this);
        }
    }

    public String getName() {
        return studentRootEntity.getBasicInfoVO().getName();
    }

    public String getContact() {
        return studentRootEntity.getBasicInfoVO().getContact();
    }

    public String getEmail() {
        return studentRootEntity.getBasicInfoVO().getEmail();
    }

    public Double getOverallGrade() {
        return studentRootEntity.getAcademicInfoVO().getOverallGrade();
    }

    public Double getTotalCredits() {
        return studentRootEntity.getAcademicInfoVO().getTotalCredits();
    }

    public String getFathersName() {
        return studentRootEntity.getBasicInfoVO().getFathersName();
    }

    public String getMothersName() {
        return studentRootEntity.getBasicInfoVO().getMothersName();
    }

    public String getFathersContact() {
        return studentRootEntity.getBasicInfoVO().getFathersContact();
    }

    public String getMothersContact() {
        return studentRootEntity.getBasicInfoVO().getMothersContact();
    }

    public Long getDob() {
        return studentRootEntity.getBasicInfoVO().getDob();
    }

    public String getStudentId() {
        return this.studentId.userId;
    }

    public Long getId() {
        return this.studentRootEntity.getId();
    }

    public List<String> getCourseIds() {
        if(this.courseIds==null) {
            return new ArrayList<>();
        }
        return this.courseIds.stream().map(courseId -> courseId.courseId).collect(Collectors.toList());
    }
}
