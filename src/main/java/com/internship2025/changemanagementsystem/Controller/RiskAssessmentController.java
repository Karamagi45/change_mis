package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Risk_assessment;
import com.internship2025.changemanagementsystem.Services.RiskAssessmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/risks")
public class RiskAssessmentController {

    private final RiskAssessmentService riskAssessmentService ;

    public RiskAssessmentController(RiskAssessmentService riskAssessmentService) {
        this.riskAssessmentService = riskAssessmentService;
    }

    @GetMapping("findAllRiskAssessment")
    public ApiResponse<?> findAllRiskAssessment(){
        return  riskAssessmentService.findAllRiskAssessment();
    }

    @PostMapping("saveRisks")
    public ApiResponse<?> saveRisks(@RequestBody Risk_assessment assessments){

        return  riskAssessmentService.saveRisks(assessments);
    }

}
