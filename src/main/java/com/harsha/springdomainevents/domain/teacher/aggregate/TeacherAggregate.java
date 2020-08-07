package com.harsha.springdomainevents.domain.teacher.aggregate;


import com.harsha.springdomainevents.domain.global.ids.PersonId;
import org.springframework.util.StringUtils;

public class TeacherAggregate {
    private TeacherRootEntity teacherRootEntity;
    private PersonId teacherId;

    private TeacherAggregate(UserAggregateBuilder builder) {
        AddressEntity addressEntity = new AddressEntity(
                builder.addressEntityId, builder.traditionalAddress, builder.googlePlaceId, builder.state, builder.country, builder.zipCode
                );
        this.teacherRootEntity = new TeacherRootEntity(
                builder.teacherEntityId,
                builder.name,
                builder.dob,
                builder.contact,
                builder.secondaryContact,
                builder.email,
                addressEntity
        );
        if(builder.teacherId!=null) {
            this.teacherId = builder.teacherId;
        } else {
            this.teacherId = new PersonId.UserIdBuilder().
                    name(builder.name)
                    .contact(builder.contact)
                    .email(builder.email)
                    .dob(builder.dob)
                    .build();
        }
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
        PersonId teacherId;
        Long teacherEntityId;
        Long addressEntityId;


        public UserAggregateBuilder teacherId(PersonId teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        public UserAggregateBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserAggregateBuilder teacherEntityId(Long teacherEntityId) {
            this.teacherEntityId = teacherEntityId;
            return this;
        }

        public UserAggregateBuilder addressEntityId(Long addressEntityId) {
            this.addressEntityId = addressEntityId;
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

    public TeacherAggregate updateAddress(String traditionalAddress,
            String googlePlaceId,
            String state,
            String country,
            String zipCode) {
        teacherRootEntity.setAddressEntity(new AddressEntity(null,
                traditionalAddress,
                googlePlaceId,
                state,
                country,
                zipCode));
        return this;
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

    public String getTeacherId() {
        return this.teacherId.userId;
    }

    public Long getTeacherEntityId() {
        return teacherRootEntity.getId();
    }

    public Long getAddressEntityId() {
        return teacherRootEntity.getAddressEntity().id;
    }

    public String getTraditionalAddress() {
        return teacherRootEntity.getAddressEntity().traditionalAddress;
    }

    public String getGooglePlaceId() {
        return teacherRootEntity.getAddressEntity().googlePlaceId;
    }

    public String getCountry() {
        return teacherRootEntity.getAddressEntity().country;
    }

    public String getState() {
        return teacherRootEntity.getAddressEntity().state;
    }

    public String getZipCode() {
        return teacherRootEntity.getAddressEntity().zipCode;
    }

    public Boolean isAddressPresent() {
        return teacherRootEntity.getAddressEntity() != null && !StringUtils.isEmpty(teacherRootEntity.getAddressEntity().googlePlaceId);
    }

}
