package com.harsha.springdomainevents.persistence.dao;

import com.harsha.springdomainevents.domain.global.ids.CourseId;
import com.harsha.springdomainevents.domain.student.aggregate.StudentAggregate;
import com.harsha.springdomainevents.domain.teacher.aggregate.TeacherAggregate;
import com.harsha.springdomainevents.persistence.models.StudentProjection;
import com.harsha.springdomainevents.persistence.models.TeacherProjection;
import com.harsha.springdomainevents.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentDAO {
    StudentRepository studentRepository;
    @Autowired
    public StudentDAO(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentAggregate createStudent(StudentAggregate studentAggregate) {
        StudentProjection studentProjection = convertAggregateToProjection(studentAggregate);
        StudentProjection saveStudentProjection = studentRepository.save(studentProjection);
        return convertProjectionToAggregate(saveStudentProjection);
    }

    private StudentProjection convertAggregateToProjection(StudentAggregate studentAggregate) {
        StudentProjection studentProjection = new StudentProjection();
        studentProjection.setId(studentAggregate.getId());
        studentProjection.setName(studentAggregate.getName());
        studentProjection.setContact(studentAggregate.getContact());
        studentProjection.setEmail(studentAggregate.getEmail());
        studentProjection.setDob(new java.sql.Date(studentAggregate.getDob()));
        studentProjection.setFathersContact(studentAggregate.getFathersContact());
        studentProjection.setMothersContact(studentAggregate.getMothersContact());
        studentProjection.setFathersName(studentAggregate.getFathersName());
        studentProjection.setMothersName(studentAggregate.getMothersName());
        studentProjection.setStudentId(studentAggregate.getStudentId());
        studentProjection.setCourseIds(studentAggregate.getCourseIds());
        return studentProjection;
    }

    private StudentAggregate convertProjectionToAggregate(StudentProjection studentProjection) {
        StudentAggregate.StudentAggregateBuilder studentAggregateBuilder = new StudentAggregate.StudentAggregateBuilder()
                .id(studentProjection.getId())
                .name(studentProjection.getName())
                .email(studentProjection.getEmail())
                .contact(studentProjection.getContact())
                .dob(studentProjection.getDob().getTime())
                .fathersName(studentProjection.getFathersName())
                .mothersName(studentProjection.getMothersName())
                .fathersContact(studentProjection.getFathersContact())
                .mothersContact(studentProjection.getMothersContact())
                .overallGrade(studentProjection.getOverallGrade())
                .totalCredits(studentProjection.getTotalCredits());
        if(studentProjection.getCourseIds()!=null) {
            studentAggregateBuilder.courseIds(studentProjection.getCourseIds().stream()
                    .map(CourseId::new).collect(Collectors.toList()));
        }
        return studentAggregateBuilder.build();
    }

    public StudentAggregate findByEmail(String email) {
        Optional<StudentProjection> studentProjection = studentRepository.findByEmail(email);
        return studentProjection.map(this::convertProjectionToAggregate).orElse(null);
    }

    public StudentAggregate findByStudentId(String studentId) {
        Optional<StudentProjection> studentProjection = studentRepository.findByStudentId(studentId);
        return studentProjection.map(this::convertProjectionToAggregate).orElse(null);
    }

    public StudentAggregate save(StudentAggregate studentAggregate) {
        StudentProjection studentProjection = convertAggregateToProjection(studentAggregate);
        StudentProjection saveStudentProjection = studentRepository.save(studentProjection);
        return convertProjectionToAggregate(saveStudentProjection);
    }
}
