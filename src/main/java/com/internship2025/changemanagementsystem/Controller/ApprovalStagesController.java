package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ApprovalStages;
import com.internship2025.changemanagementsystem.Services.ApprovalStagesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/approvalStages")
public class ApprovalStagesController {

    private final ApprovalStagesService approvalStagesService;

    public ApprovalStagesController(ApprovalStagesService approvalStagesService) {
        this.approvalStagesService = approvalStagesService;
    }

    @PostMapping("addApprovalStage")
    public ApiResponse<?> addApprovalStage(@RequestBody ApprovalStages approvalStages){
        return  approvalStagesService.addApprovalStage(approvalStages);
    }

    @PutMapping("updateApprovalStage")
    public ApiResponse<?> updateApprovalStage(@RequestBody  ApprovalStages approvalStages){
        return  approvalStagesService.updateApprovalStage(approvalStages);
    }


    @DeleteMapping("deleteApprovalStage")
    public ApiResponse<?> deleteApprovalStage(@RequestBody  ApprovalStages approvalStages){
        return  approvalStagesService.deleteApprovalStage(approvalStages);
    }

    @GetMapping("getApprovalStage")
    public ApiResponse<?> getApprovalStage(ApprovalStages approvalStages){
        return approvalStagesService.getApprovalStage(approvalStages);
    }

}
