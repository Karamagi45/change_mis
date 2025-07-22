package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class ChangeDetail {
   private Integer changeRequestId;
   private String sourceOfChange ;
   private String  typeOfChange ;
   private String requestBy ;
   private String clientName ;
   private String costImplementation  ;
   private String changeDescriptionObjection;

}
