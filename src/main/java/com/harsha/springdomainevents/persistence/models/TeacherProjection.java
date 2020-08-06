package com.harsha.springdomainevents.persistence.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "teacher", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Data
public class TeacherProjection extends BaseProjection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

    @Column(name = "secondary_contact")
    private String secondaryContact;

    @Column(name = "dob")
    private Date dob;

    @OneToOne(mappedBy = "teacherProjection")
    AddressProjection addressProjection;

    public TeacherProjection() {

    }
}
