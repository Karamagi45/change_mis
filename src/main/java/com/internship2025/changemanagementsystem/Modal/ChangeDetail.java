package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.List;

@Data
public class ChangeDetail {
   private Integer changeRequestId;
   private String sourceOfChange ;
   private List typeOfChange ;
   private String requestBy ;
   private String clientName ;
   private String costImplementation  ;
   private String changeDescriptionObjection;

}
