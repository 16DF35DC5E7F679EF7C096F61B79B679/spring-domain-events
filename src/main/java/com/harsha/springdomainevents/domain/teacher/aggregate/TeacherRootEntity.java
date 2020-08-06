package com.harsha.springdomainevents.domain.teacher.aggregate;

class TeacherRootEntity {
    private String name;
    private Long dob;
    private AddressEntity addressEntity;
    private String contact;
    private String secondaryContact;
    private String email;

    public TeacherRootEntity(String name, Long dob, String contact, String secondaryContact, String email,
                             AddressEntity addressEntity) {
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

}
