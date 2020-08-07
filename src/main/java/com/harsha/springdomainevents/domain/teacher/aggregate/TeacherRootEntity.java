package com.harsha.springdomainevents.domain.teacher.aggregate;

class TeacherRootEntity {
    private Long id;
    private String name;
    private Long dob;
    private AddressEntity addressEntity;
    private String contact;
    private String secondaryContact;
    private String email;

    public TeacherRootEntity(Long id, String name, Long dob, String contact, String secondaryContact, String email,
                             AddressEntity addressEntity) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.secondaryContact = secondaryContact;
        this.email = email;
        this.addressEntity = addressEntity;
    }

    String getName() {
        return name;
    }

    Long getDob() {
        return dob;
    }

    AddressEntity getAddressEntity() {
        return addressEntity;
    }

    String getContact() {
        return contact;
    }

    String getSecondaryContact() {
        return secondaryContact;
    }

    String getEmail() {
        return email;
    }

    Long getId() {return id;}

    void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

}
