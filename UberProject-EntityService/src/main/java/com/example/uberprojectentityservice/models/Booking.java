package com.example.uberprojectentityservice.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(indexes = {@Index(columnList = "driver_id")})
public class Booking extends BaseModel{
    
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startingTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date EndingTime;

    private long totalDistance;

    @Enumerated(value = EnumType.STRING) //Stores enum as a string in database
    private BookingStatus bookingStatus;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

    @OneToOne
    private ExactLocation pickupLocation;

    @OneToOne
    private ExactLocation dropOffLocation;

}