package com.harsha.springdomainevents.persistence.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class AddressProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "traditional_address")
    private String traditionalAddress;

    @Column(name = "google_place_id")
    private String googlePlaceId;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    TeacherProjection teacherProjection;

}
