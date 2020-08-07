package com.harsha.springdomainevents.domain.teacher.service;

import com.harsha.springdomainevents.domain.event.events.TeacherCreatedEvent;
import com.harsha.springdomainevents.domain.teacher.aggregate.TeacherAggregate;
import com.harsha.springdomainevents.dtos.request.AddAddressRequestDTO;
import com.harsha.springdomainevents.dtos.request.CreateTeacherRequestDTO;
import com.harsha.springdomainevents.dtos.response.TeacherResponseDTO;
import com.harsha.springdomainevents.persistence.dao.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TeacherService {

    TeacherDAO teacherDAO;

    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public TeacherService(TeacherDAO teacherDAO, ApplicationEventPublisher applicationEventPublisher) {
        this.teacherDAO = teacherDAO;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public TeacherResponseDTO createTeacher(CreateTeacherRequestDTO createTeacherRequestDTO) {
        TeacherAggregate teacherAggregate = convertRequestDTOToAggregate(createTeacherRequestDTO);
        TeacherAggregate createdTeacherAggregate = teacherDAO.createTeacher(teacherAggregate);
        applicationEventPublisher.publishEvent(new TeacherCreatedEvent(createdTeacherAggregate));
        return convertAggregateToResponseDTO(createdTeacherAggregate);
    }

    private TeacherAggregate convertRequestDTOToAggregate(CreateTeacherRequestDTO createTeacherRequestDTO) {
        return new TeacherAggregate.UserAggregateBuilder()
                .name(createTeacherRequestDTO.getName())
                .contact(createTeacherRequestDTO.getContact())
                .email(createTeacherRequestDTO.getEmail())
                .dob(createTeacherRequestDTO.getDob())
                .secondaryContact(createTeacherRequestDTO.getSecondaryContact())
                .build();
    }

    private TeacherResponseDTO convertAggregateToResponseDTO(TeacherAggregate teacherAggregate){
        TeacherResponseDTO.AddressResponseDTO addressResponseDTO = new TeacherResponseDTO.AddressResponseDTO(
                teacherAggregate.getAddressEntityId(),
                teacherAggregate.getTraditionalAddress(),
                teacherAggregate.getGooglePlaceId(),
                teacherAggregate.getState(),
                teacherAggregate.getCountry(),
                teacherAggregate.getZipCode()
        );
        return new TeacherResponseDTO(
                teacherAggregate.getTeacherId(), teacherAggregate.getName(), teacherAggregate.getEmail(), teacherAggregate.getContact(),
                teacherAggregate.getSecondaryContact(), teacherAggregate.getDob().toString(), addressResponseDTO
                );
    }

    public TeacherResponseDTO addAddress(String id, AddAddressRequestDTO addAddressRequestDTO) {
        TeacherAggregate teacherAggregate = teacherDAO.findByTeacherId(id);
        TeacherAggregate updatedTeacherAggregate = teacherAggregate.updateAddress(addAddressRequestDTO.getTraditionalAddress(),
                addAddressRequestDTO.getGooglePlaceId(),
                addAddressRequestDTO.getState(),
                addAddressRequestDTO.getCountry(),
                addAddressRequestDTO.getZipCode());
        return convertAggregateToResponseDTO(teacherDAO.save(updatedTeacherAggregate));
    }
}
