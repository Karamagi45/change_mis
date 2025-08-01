package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ApprovalProcess;
import com.internship2025.changemanagementsystem.Services.ApprovalProcessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/approvalProcess")
public class ApprovalProcessController {

    private final ApprovalProcessService approvalProcessService;

    public ApprovalProcessController(ApprovalProcessService approvalProcessService) {
        this.approvalProcessService = approvalProcessService;
    }

    @PostMapping("addApprovalProcess")
    public ApiResponse<?> addApprovalProcess(@RequestBody ApprovalProcess approvalProcess){
        return approvalProcessService.addApprovalProcess(approvalProcess);
    }

    @PutMapping("updateApprovalProcess")
    public ApiResponse<?> updateApprovalProcess(@RequestBody  ApprovalProcess approvalProcess){
        return approvalProcessService.updateApprovalProcess(approvalProcess);
    }

    @DeleteMapping("deleteApprovalProcess")
    public ApiResponse<?> deleteApprovalProcess(@RequestBody ApprovalProcess approvalProcess){
        return approvalProcessService.deleteApprovalProcess(approvalProcess);
    }

    @GetMapping("getApprovalProcess")
    public ApiResponse<?> getApprovalProcess(ApprovalProcess approvalProcess){
        return approvalProcessService.getApprovalProcess(approvalProcess);
    }
}
