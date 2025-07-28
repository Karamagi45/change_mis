package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.OtpModel;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import com.internship2025.changemanagementsystem.Services.ForgetPasswordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final ForgetPasswordService forgetPasswordService;

    public AuthController(ForgetPasswordService forgetPasswordService) {
        this.forgetPasswordService = forgetPasswordService;
    }

    @PostMapping("validateOtpByEmail")
    public ApiResponse<?> validateOtpByEmail(@RequestBody  OtpModel otpModel){
        return  forgetPasswordService.validateOtpByEmail(otpModel);
    }

    @PostMapping("updatePassword")
    public ApiResponse<?> updatePassword(@RequestBody UsersModel  usersModel){
        return  forgetPasswordService.updatePassword(usersModel);
    }

    @PutMapping("updateFullName")
    public ApiResponse<?> updateFullName(@RequestBody UsersModel usersModel) {
        return  forgetPasswordService.updateFullName(usersModel);
    }

    @PostMapping("saveOtpRecord")
    public ApiResponse<?> saveOtpRecord(@RequestBody  OtpModel otpModel) {
        return  forgetPasswordService.saveOtpRecord(otpModel);
    }

    @PostMapping("forgetPassword")
    public ApiResponse<?> forgetPassword(@RequestBody OtpModel otpModel){
        return  forgetPasswordService.forgetPassword(otpModel.getEmail());
    }
//
//    @GetMapping("generateOTP")
//    public Object generateOTP(){
//        return forgetPasswordService.generateOTP() ;
//    }

//    @GetMapping("dateUsers")
//    public String dateUsers(){
//        return forgetPasswordService.dateUsers() ;
//    }
}
