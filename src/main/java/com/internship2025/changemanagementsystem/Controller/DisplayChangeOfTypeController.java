package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Services.DisplayChangeOfTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/changeDisplays")
public class DisplayChangeOfTypeController {

    private final DisplayChangeOfTypeService displayChangeOfTypeService;


    public DisplayChangeOfTypeController(DisplayChangeOfTypeService displayChangeOfTypeService) {
        this.displayChangeOfTypeService = displayChangeOfTypeService;
    }

    @GetMapping("getTypeOfChange")
    public ApiResponse<?> getTypeOfChange(){
        return  displayChangeOfTypeService.getTypeOfChange();
    }
}
