package com.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false, unique = true)
    private String licenceNumber;

    private String phoneNumber;


    @DecimalMax(value = "5.00", message = "Rating should be between 0 and 5")
    @DecimalMin(value = "0.00", message = "Rating should be between 0 and 5")
    private double rating;

    //One to many 1:n

    @OneToMany(mappedBy = "driver")
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation lastKnownLocation;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation home;

    private String activeCity;

    private boolean isAvailable;


}