package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Change_detail;
import com.internship2025.changemanagementsystem.Modal.Change_impact_evaluation;
import com.internship2025.changemanagementsystem.Repostory.ChangeEvaluationRepo;
import com.internship2025.changemanagementsystem.Services.ChangeEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/changes")
public class ChangeEvaluationController {

    private  final ChangeEvaluationService changeEvaluationService;

    public ChangeEvaluationController(ChangeEvaluationService changeEvaluationService) {
        this.changeEvaluationService = changeEvaluationService;
    }

    @PostMapping("addChangeEvaluation")
    public ApiResponse<?> addChangeEvaluation( @RequestBody Change_impact_evaluation  evaluation) {
        return changeEvaluationService.addChangeEvaluation(evaluation);
    }

    @GetMapping("fetchChangeEvaluation")
    public ApiResponse<?> fetchChangeEvaluation() {
        return changeEvaluationService.fetchChangeEvaluation();
    }


}
