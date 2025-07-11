package com.internship2025.changemanagementsystem.Modal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiResponse <T>{
    private Integer code;
    private T data;
    private  String message;
}
