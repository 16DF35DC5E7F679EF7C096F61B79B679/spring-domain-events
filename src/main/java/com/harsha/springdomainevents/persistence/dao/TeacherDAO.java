package com.harsha.springdomainevents.persistence.dao;

import com.harsha.springdomainevents.domain.teacher.aggregate.TeacherAggregate;
import com.harsha.springdomainevents.persistence.models.AddressProjection;
import com.harsha.springdomainevents.persistence.models.TeacherProjection;
import com.harsha.springdomainevents.persistence.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

@Component
public class TeacherDAO {

    TeacherRepository teacherRepository;

    @Autowired
    public TeacherDAO(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherAggregate findById(Long teacherId) {
        Optional<TeacherProjection> teacherProjection = teacherRepository.findById(teacherId);
        if(teacherProjection.isPresent()) {
            return convertProjectionToAggregate(teacherProjection.get());
        }
        return new TeacherAggregate.UserAggregateBuilder()
                .name("Harsha Vardhan")
                .contact("9113709670")
                .dob(218023032L)
                .country("India")
                .email("harsha.live1@gmail.com")
                .build();
    }

    public TeacherAggregate findByEmail(String email) {
        Optional<TeacherProjection> teacherProjection = teacherRepository.findByEmail(email);
        return teacherProjection.map(this::convertProjectionToAggregate).orElse(null);
    }

    public TeacherAggregate createTeacher(TeacherAggregate teacherAggregate) {
        TeacherProjection teacherProjection = convertAggregateToProjection(teacherAggregate);
        TeacherProjection savedTeacherProjection = teacherRepository.save(teacherProjection);
        return teacherAggregate;
    }

    private TeacherProjection convertAggregateToProjection(TeacherAggregate teacherAggregate) {
        TeacherProjection teacherProjection = new TeacherProjection();
        teacherProjection.setName(teacherAggregate.getName());
        teacherProjection.setEmail(teacherAggregate.getEmail());
        teacherProjection.setContact(teacherAggregate.getContact());
        teacherProjection.setSecondaryContact(teacherAggregate.getContact());
        teacherProjection.setDob(new java.sql.Date(teacherAggregate.getDob()));
        return teacherProjection;
    }


    private TeacherAggregate convertProjectionToAggregate(TeacherProjection teacherProjection) {
        AddressProjection addressProjection = teacherProjection.getAddressProjection();
        TeacherAggregate.UserAggregateBuilder userAggregateBuilder = new TeacherAggregate.UserAggregateBuilder()
                .name(teacherProjection.getName())
                .email(teacherProjection.getEmail())
                .contact(teacherProjection.getContact())
                .secondaryContact(teacherProjection.getSecondaryContact())
                .dob(teacherProjection.getDob().getTime());

        if(addressProjection!=null) {
            userAggregateBuilder.country(addressProjection.getCountry())
                    .googlePlaceId(addressProjection.getGooglePlaceId())
                    .state(addressProjection.getState())
                    .traditionalAddress(addressProjection.getTraditionalAddress())
                    .zipCode(addressProjection.getZipCode());
        }
        return userAggregateBuilder.build();
    }
}
