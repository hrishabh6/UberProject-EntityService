package com.example.uberprojectentityservice.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "passenger")
    private List<Booking> passengerBookings = new ArrayList<>();

    @OneToOne
    private Booking activeBooking;

    @DecimalMax(value = "5.00", message = "Rating should be between 0 and 5")
    @DecimalMin(value = "0.00", message = "Rating should be between 0 and 5")
    private double rating;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;



}