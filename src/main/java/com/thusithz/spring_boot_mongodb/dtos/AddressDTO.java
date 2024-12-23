package com.thusithz.spring_boot_mongodb.dtos;


import com.thusithz.spring_boot_mongodb.models.AddressEntity;

public record AddressDTO(int number, String street, String postcode, String city, String country) {

    public AddressDTO(AddressEntity a) {
        this(a.getNumber(), a.getStreet(), a.getPostcode(), a.getCity(), a.getCountry());
    }

    public AddressEntity toAddressEntity() {
        return new AddressEntity(number, street, postcode, city, country);
    }
}
