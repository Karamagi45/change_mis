package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChangeImplementation {

   private Integer changeImplementationId ;
   private LocalDateTime dateTimeImplementation;
   private String signature;
   private String changeImplemented;
   private String  comments ;
   private String  implementedBy;
   private Integer changeRequestId ;

}
