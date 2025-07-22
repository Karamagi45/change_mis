package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class ChangeImpactEvaluation {
   private String changeType;
   private String changePriority ;
   private String changeImpact ;
   private String summaryResult ;
   private String conductedBy  ;
   private String impacted  ;
   private Integer change_impactId;


}
