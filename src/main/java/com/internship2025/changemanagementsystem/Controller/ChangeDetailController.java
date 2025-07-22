package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ChangeDetail;
import com.internship2025.changemanagementsystem.Services.ChangeDetailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/changes")
public class ChangeDetailController {

    private final ChangeDetailService changeDetailService;

    public ChangeDetailController(ChangeDetailService changeDetailService) {
        this.changeDetailService = changeDetailService;
    }


    @PostMapping("updateChangeDetail")
    public ApiResponse<?> updateChangeDetail(@RequestBody  ChangeDetail change_detail) {
        return changeDetailService.updateChangeDetail(change_detail);
    }

    @GetMapping("findChangeDetails")
    public ApiResponse<?> findChangeDetails() {
        return changeDetailService.findChangeDetails();
    }

    @PostMapping("newChangeDetail")
    public ApiResponse<?> newChangeDetail(@RequestBody ChangeDetail change_detail) {
        return changeDetailService.newChangeDetail(change_detail);
    }

}
