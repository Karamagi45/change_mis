package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Services.DisplayRiskLikelihoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/riskLikes")
public class DisplayRiskLikelihoodController {

    private final DisplayRiskLikelihoodService displayRiskLikelihoodService;


    public DisplayRiskLikelihoodController(DisplayRiskLikelihoodService displayRiskLikelihoodService) {
        this.displayRiskLikelihoodService = displayRiskLikelihoodService;
    }

    @GetMapping("getDisplayRiskLikelihood")
    public ApiResponse<?> getDisplayRiskLikelihood(){
        return displayRiskLikelihoodService.getDisplayRiskLikelihood();
    }


}
