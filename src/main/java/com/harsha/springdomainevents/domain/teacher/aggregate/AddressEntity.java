package com.harsha.springdomainevents.domain.teacher.aggregate;

class AddressEntity {

    String traditionalAddress;
    String googlePlaceId;
    String state;
    String country;
    String zipCode;

    public AddressEntity(String traditionalAddress, String googlePlaceId, String state, String country, String zipCode) {
        this.traditionalAddress = traditionalAddress;
        this.googlePlaceId = googlePlaceId;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
