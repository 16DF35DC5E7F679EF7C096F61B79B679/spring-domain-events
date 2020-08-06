package com.harsha.springdomainevents.persistence.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class_location")
public class ClassLocationProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "hall_number")
    private String hallNumber;

    @Column(name = "building_name")
    private String buildingName;

    @OneToMany(mappedBy = "classLocationProjection")
    private List<ClassProjection> classProjections;
}
