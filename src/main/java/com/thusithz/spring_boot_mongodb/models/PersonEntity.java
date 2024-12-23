package com.thusithz.spring_boot_mongodb.models;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {

    private ObjectId id;
    private String firstName;
    private String lastName;
    private int age;
    private AddressEntity addressEntity;
    private Date createdAt = new Date();
    private Boolean insurance;
    private List<CarEntity> carEntities;

}
