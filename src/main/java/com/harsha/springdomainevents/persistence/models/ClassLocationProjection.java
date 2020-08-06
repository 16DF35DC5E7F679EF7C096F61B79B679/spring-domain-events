package com.harsha.springdomainevents.persistence.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class_location")
@Data
public class ClassLocationProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "class_location_id")
    private String classLocationId;

    @Column(name = "hall_number")
    private String hallNumber;

    @Column(name = "building_name")
    private String buildingName;

    @ElementCollection
    private List<String> classIds;
}
