package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Services.ChangeRequestFormService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/changeForms")
public class ChangeRequestFormController {

    private final ChangeRequestFormService changeRequestFormService;

    public ChangeRequestFormController(ChangeRequestFormService changeRequestFormService) {
        this.changeRequestFormService = changeRequestFormService;
    }

    @GetMapping("getChangeRequestForm")
    public ApiResponse<?> getChangeRequestForm(){
        return changeRequestFormService.getChangeRequestForm();
    }

    @GetMapping("showLastKeyNumber()")
    public ApiResponse<?> showLastKeyNumber(){
        return changeRequestFormService.showLastKeyNumber();
    }

    @GetMapping("getChangeRequestForm2")
    public ApiResponse<?> getChangeRequestForm2(){
        return changeRequestFormService.getChangeRequestForm2();
    }


    @GetMapping("getChangeRequestForm3")
    public ApiResponse<?> getChangeRequestForm3() {
        return changeRequestFormService.getChangeRequestForm3();
    }

}
