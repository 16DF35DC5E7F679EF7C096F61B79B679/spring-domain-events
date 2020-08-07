package com.harsha.springdomainevents.domain.teacher.aggregate;

class AddressEntity {

    Long id;
    String traditionalAddress;
    String googlePlaceId;
    String state;
    String country;
    String zipCode;

    public AddressEntity(Long id, String traditionalAddress, String googlePlaceId, String state, String country, String zipCode) {
        this.id = id;
        this.traditionalAddress = traditionalAddress;
        this.googlePlaceId = googlePlaceId;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
