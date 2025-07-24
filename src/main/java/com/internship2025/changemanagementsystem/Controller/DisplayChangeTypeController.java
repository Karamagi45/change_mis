package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Services.DisplayChangeOfTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/changeTypes")
public class DisplayChangeTypeController {

    private  final DisplayChangeOfTypeService displayChangeOfTypeService;

    public DisplayChangeTypeController(DisplayChangeOfTypeService displayChangeOfTypeService) {
        this.displayChangeOfTypeService = displayChangeOfTypeService;
    }


    @RequestMapping("getDisplayChangeType")
    public ApiResponse<?> getDisplayChangeType() {
        return displayChangeOfTypeService.getTypeOfChange();
    }

}
