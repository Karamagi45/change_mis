package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class UsersModel {

   private Integer user_id ;
   private String fullName;
   private  String  email;
   private String password;
   private String confirmPassword;
   private String role;
   private Integer phone;

}

