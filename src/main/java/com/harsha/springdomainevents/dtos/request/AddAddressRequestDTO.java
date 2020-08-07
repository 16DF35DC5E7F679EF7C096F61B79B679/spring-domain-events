package com.harsha.springdomainevents.dtos.request;

import lombok.Data;

@Data
public class AddAddressRequestDTO {
    String traditionalAddress;
    String googlePlaceId;
    String state;
    String country;
    String zipCode;
}
