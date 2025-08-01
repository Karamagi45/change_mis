package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class RiskAssessment {

    private Integer riskAssessmentId;
    private String riskType;
    private String riskLikelihood;
    private  String riskImpact;
    private  Integer changeRequestId;

}
