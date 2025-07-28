package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ChangePassword;
import com.internship2025.changemanagementsystem.Modal.ProfileModal;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import com.internship2025.changemanagementsystem.Services.ProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("profileByEmail")
    public ApiResponse<?> profileByEmail(@RequestBody ProfileModal profileModal) {
        return profileService.profileByEmail(profileModal);
    }

    @PutMapping("changePassword")
    public ApiResponse<?> changePassword(@RequestBody ChangePassword  changePassword) {

        return profileService.changePassword(changePassword);
    }

}
