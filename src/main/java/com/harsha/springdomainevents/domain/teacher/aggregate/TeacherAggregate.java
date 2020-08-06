package com.harsha.springdomainevents.domain.teacher.aggregate;


public class TeacherAggregate {
    private TeacherRootEntity teacherRootEntity;

    private TeacherAggregate(UserAggregateBuilder builder) {
        AddressEntity addressEntity = new AddressEntity(
                builder.traditionalAddress, builder.googlePlaceId, builder.state, builder.country, builder.zipCode
                );
        this.teacherRootEntity = new TeacherRootEntity(
                builder.name,
                builder.dob,
                builder.contact,
                builder.secondaryContact,
                builder.email,
                addressEntity
        );
    }

    public static class UserAggregateBuilder {
        String name;
        Long dob;
        String contact;
        String secondaryContact;
        String email;
        String traditionalAddress;
        String googlePlaceId;
        String state;
        String country;
        String zipCode;

        public UserAggregateBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserAggregateBuilder dob(Long dob) {
            this.dob = dob;
            return this;
        }

        public UserAggregateBuilder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public UserAggregateBuilder secondaryContact(String secondaryContact) {
            this.secondaryContact = secondaryContact;
            return this;
        }

        public UserAggregateBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserAggregateBuilder traditionalAddress(String traditionalAddress) {
            this.traditionalAddress = traditionalAddress;
            return this;
        }

        public UserAggregateBuilder googlePlaceId(String googlePlaceId) {
            this.googlePlaceId = googlePlaceId;
            return this;
        }

        public UserAggregateBuilder state(String state) {
            this.state = state;
            return this;
        }

        public UserAggregateBuilder country(String country) {
            this.country = country;
            return this;
        }

        public UserAggregateBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public TeacherAggregate build() {
            return new TeacherAggregate(this);
        }
    }

    public String getName() {
        return teacherRootEntity.getName();
    }

    public String getEmail() {
        return teacherRootEntity.getEmail();
    }

    public Long getDob() {
        return teacherRootEntity.getDob();
    }

    public String getContact() {
        return teacherRootEntity.getContact();
    }

    public String getSecondaryContact() {
        return teacherRootEntity.getSecondaryContact();
    }
}
