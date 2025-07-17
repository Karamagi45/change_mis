package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OtpModel {

    private Integer otpId;
    private Integer otpCode;
    private String email;
    private String status;
   private LocalDateTime createdDate;
}
