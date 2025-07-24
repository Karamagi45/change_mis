package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Repostory.DisplayChangeImpactRepo;
import com.internship2025.changemanagementsystem.Services.DisplayChangeImpactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/changeImpact")
public class DisplayChangeImpactController {

   private final DisplayChangeImpactService displayChangeImpactService;

    public DisplayChangeImpactController(DisplayChangeImpactService displayChangeImpactService) {
        this.displayChangeImpactService = displayChangeImpactService;
    }

    @GetMapping("getDisplayChangeImpact")
    public ApiResponse<?> getDisplayChangeImpact() {
        return displayChangeImpactService.getDisplayChangeImpact();
    }
}
