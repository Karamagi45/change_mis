package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Services.DisplayChangePriorityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/changePriority")
public class DisplayChangePriorityController {

    private  final DisplayChangePriorityService displayChangePriorityService;

    public DisplayChangePriorityController(DisplayChangePriorityService displayChangePriorityService) {
        this.displayChangePriorityService = displayChangePriorityService;
    }

    @GetMapping("getDisplayChangePriority")
    public ApiResponse<?> getDisplayChangePriority() {
        return displayChangePriorityService.getDisplayChangePriority();
    }

}
