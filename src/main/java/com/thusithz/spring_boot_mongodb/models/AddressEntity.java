package com.thusithz.spring_boot_mongodb.models;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    private int number;
    private String street;
    private String postcode;
    private String city;
    private String country;
}
