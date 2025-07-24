package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

import java.util.List;

@Data
public class ChangeImpactEvaluation {
   private List<String> changeType;
   private String changePriority ;
   private String changeImpact ;
   private String summaryResult ;
   private String conductedBy  ;
   private String impacted  ;
   private Integer impactedChangeId;


}
