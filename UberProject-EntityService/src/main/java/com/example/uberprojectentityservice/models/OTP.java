package com.example.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OTP extends BaseModel{
    private String otp;
    private String phoneNumber;

    public static OTP createOTP(String phoneNumber){
        Random random = new Random();
        Integer otp = 1000 + random.nextInt(9000);
        return OTP.builder().phoneNumber(phoneNumber).otp(otp.toString()).build();
    }

}
