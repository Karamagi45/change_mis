package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class ChangeApprovalRejection {

   private Integer changeProofId;
   private Integer changeRequestId;
   private String changeRequestStatus ;
   private String comments;
   private String changeControlCommittee;
   private String leadSoftwareEngineer ;
   private String projectManager;
   private String leadInfrastructureDatabase ;
   private String headConsultSupportDepartment ;


}
