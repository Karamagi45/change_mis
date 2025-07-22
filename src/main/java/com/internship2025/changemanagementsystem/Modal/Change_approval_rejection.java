package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Change_approval_rejection {

   private String changeRequestStatus ;
   private String comments;
   private String changeControlCommittee;
   private String leadSoftwareEngineer ;
   private String projectManager;
   private String leadInfrastructureDatabase ;
   private String headConsultSupportDepartment ;
   private Integer changeProofId;

}
