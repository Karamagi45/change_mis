package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class ChangeFormData {
    // Change Detail fields
    private String sourceOfChange;
    private String typeOfChange;
    private String requestBy;
    private String costImplementation;
    private String changeDescriptionObjection;

    // Risk Assessment fields
    private String riskType;
    private String riskImpact;
    private String changeType;

    // Change Impact Evaluation fields
    private String changePriority;
    private String changeImpact;
    private String summaryResult;
    private String conductedBy;
    private String impacted;
    private Integer changeRequestId;

}
