package com.harsha.springdomainevents.domain.student.aggregate;

class BasicInfoVO {
    private String name;
    private String contact;
    private String email;
    private Long dob;
    private String fathersName;
    private String mothersName;
    private String fathersContact;
    private String mothersContact;

    public BasicInfoVO(String name, String contact, String email, String fathersName, String mothersName,
                       String fathersContact, String mothersContact, Long dob) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.fathersContact = fathersContact;
        this.mothersContact = mothersContact;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public String getFathersContact() {
        return fathersContact;
    }

    public String getMothersContact() {
        return mothersContact;
    }

    public Long getDob() {
        return this.dob;
    }
}