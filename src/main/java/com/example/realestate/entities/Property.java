package com.example.realestate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity(name = "properties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id // qeles primar
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 2000)
    private String description; //VARCHAR(2000)
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String location; //VARCHAR(255)
    private String type;

    @Column(nullable = false)
    private int bedrooms = 0;

    @Column(nullable = false)
    private float bathrooms;

    @Column(nullable = false)
    private int squareMeters; // square_meters

    @Column(length = 2000)
    private String image;

    private int floorNo; //floor_no
    private int doorNumber;

    private boolean passive = false;
    private boolean sold = false;


}
