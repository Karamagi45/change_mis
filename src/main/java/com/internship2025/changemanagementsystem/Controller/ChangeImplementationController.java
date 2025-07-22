package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ChangeImplementation;
import com.internship2025.changemanagementsystem.Services.ChangeImplementationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/change")
public class ChangeImplementationController {

    private final ChangeImplementationService changeImplementationService;

    public ChangeImplementationController(ChangeImplementationService changeImplementationService) {
        this.changeImplementationService = changeImplementationService;
    }

    @PostMapping("addChangeImpl")
    public ApiResponse<?> addChangeImpl(@RequestBody ChangeImplementation implementation) {
        return changeImplementationService.addChangeImpl(implementation);
    }

    @PostMapping("updateChangeImpl")
    public ApiResponse<?> updateChangeImpl(@RequestBody ChangeImplementation implementation) {
        return changeImplementationService.updateChangeImpl(implementation);
    }

    @GetMapping("findChangeImpl")
    public ApiResponse<?> findChangeImpl() {
        return changeImplementationService.findChangeImpl();

    }


}
