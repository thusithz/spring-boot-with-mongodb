package com.thusithz.spring_boot_mongodb.models;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    private String brand;
    private String model;
    private Float maxSpeedKmH;
}
