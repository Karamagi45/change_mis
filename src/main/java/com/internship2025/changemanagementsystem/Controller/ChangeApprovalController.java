package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Change_approval_rejection;
import com.internship2025.changemanagementsystem.Services.ChangeApprovalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/approvals")
public class ChangeApprovalController {

    private final  ChangeApprovalService changeApprovalService;

    public ChangeApprovalController(ChangeApprovalService changeApprovalService) {
        this.changeApprovalService = changeApprovalService;
    }


    @PostMapping("addChangeApproval")
    public ApiResponse<?> addChangeApproval(@RequestBody Change_approval_rejection rejection){
        return changeApprovalService.addChangeApproval(rejection);
    }


    @GetMapping("fetchChangeApproval")
    public ApiResponse<?> fetchChangeApproval(){
        return changeApprovalService.fetchChangeApproval();
    }


}
