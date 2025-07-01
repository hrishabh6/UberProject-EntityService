package com.databases.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDTO {

    private String content;

    private Double rating;

    private Long bookingId;
}