package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChangeFormData2 {

    // Change Detail fields
    private String sourceOfChange;
    private String typeOfChange;
    private String requestBy;
    private String costImplementation;
    private String changeDescriptionObjection;

    // Change Approval/Rejection fields
    private String changeRequestStatus;
    private String comments;
    private String changeControlCommittee;
    private String leadSoftwareEngineer;
    private String projectManager;
    private String leadInfrastructureDatabase;
    private String headConsultSupportDepartment;

    // Change Implementation fields
    private String changeImplemented;
    private LocalDateTime dateTimeImplementation;
    private String implementedBy;
    private String signature;
    private Integer changeRequestId;


}
