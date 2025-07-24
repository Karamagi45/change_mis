package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Services.DisplayRiskImpactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/riskImpact")
public class DisplayRiskImpactController {

    private final DisplayRiskImpactService displayRiskImpactService;

    public DisplayRiskImpactController(DisplayRiskImpactService displayRiskImpactService) {
        this.displayRiskImpactService = displayRiskImpactService;
    }


    @GetMapping("getDisplayRiskImpact")
    public ApiResponse<?> getDisplayRiskImpact(){
        return displayRiskImpactService.getDisplayRiskImpact();
    }
}
