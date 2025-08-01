package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ChangeImpactEvaluation;
import com.internship2025.changemanagementsystem.Services.ChangeImpactEvaluationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/changes")
public class ChangeImpactEvaluationController {

    private  final ChangeImpactEvaluationService changeImpactEvaluationService;

    public ChangeImpactEvaluationController(ChangeImpactEvaluationService changeImpactEvaluationService) {
        this.changeImpactEvaluationService = changeImpactEvaluationService;
    }


    @PostMapping("addChangeEvaluation")
    public ApiResponse<?> addChangeEvaluation( @RequestBody  @Validated ChangeImpactEvaluation evaluation) {
        return changeImpactEvaluationService.addChangeEvaluation(evaluation);
    }

    @GetMapping("fetchChangeEvaluation")
    public ApiResponse<?> fetchChangeEvaluation() {
        return changeImpactEvaluationService.fetchChangeEvaluation();
    }

    @GetMapping("showLastKeyNumber")
    public ApiResponse<?> showLastKeyNumber(){
        return changeImpactEvaluationService.showLastKeyNumber();
    }


}
