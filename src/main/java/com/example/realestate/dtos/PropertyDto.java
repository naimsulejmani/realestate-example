package com.example.realestate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private UUID id;

    private String title;
    private String description; //VARCHAR(2000)
    private double price;
    private String location; //VARCHAR(255)
    private String type;
    private int bedrooms = 0;
    private float bathrooms;
    private int squareMeters; // square_meters
    private String image;
    private int floorNo; //floor_no
    private int doorNumber;
    private boolean passive = false;
    private boolean sold = false;
}
