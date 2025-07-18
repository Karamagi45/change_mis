package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.Change_detail;
import com.internship2025.changemanagementsystem.Services.ChangeDetailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/changes")
public class ChangeDetailController {

    private final ChangeDetailService changeDetailService;

    public ChangeDetailController(ChangeDetailService changeDetailService) {
        this.changeDetailService = changeDetailService;
    }

    @GetMapping("findChangeDetails")
    public ApiResponse<?> findChangeDetails(){
        return changeDetailService.findChangeDetails();
    }

    @PostMapping("newChangeDetail")
    public ApiResponse<?> newChangeDetail(@RequestBody Change_detail  change_detail) {
        return changeDetailService.newChangeDetail(change_detail);
    }

}
