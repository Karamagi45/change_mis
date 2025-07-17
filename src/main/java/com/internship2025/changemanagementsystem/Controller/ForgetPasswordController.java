package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.OtpModel;
import com.internship2025.changemanagementsystem.Services.ForgetPasswordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forgottenPassword")
public class ForgetPasswordController {

    private final ForgetPasswordService forgetPasswordService;

    public ForgetPasswordController(ForgetPasswordService forgetPasswordService) {
        this.forgetPasswordService = forgetPasswordService;
    }

    @PostMapping("validateOtpByEmail")
    public ApiResponse<?> validateOtpByEmail(@RequestBody  OtpModel otpModel){
        return  forgetPasswordService.validateOtpByEmail(otpModel);
    }


    @PostMapping("saveOtpRecord")
    public ApiResponse<?> saveOtpRecord(@RequestBody  OtpModel otpModel) {
        return  forgetPasswordService.saveOtpRecord(otpModel);
    }

    @PostMapping("forgetPassword")
    public ApiResponse<?> forgetPassword(@RequestBody OtpModel otpModel){
        return  forgetPasswordService.forgetPassword(otpModel.getEmail());
    }

    @GetMapping("generateOTP")
    public Object generateOTP(){
        return forgetPasswordService.generateOTP() ;
    }

//    @GetMapping("dateUsers")
//    public String dateUsers(){
//        return forgetPasswordService.dateUsers() ;
//    }
}
