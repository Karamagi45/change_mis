package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.ProfileModal;
import com.internship2025.changemanagementsystem.Repostory.ProfileRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProfileService implements Constant {

    private final ProfileRepo profileRepo;


    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public ApiResponse<?> profileByEmail(ProfileModal  profileModal) {
        try {
            List<ProfileModal> profileResponse = profileRepo.profileByEmail(
                    profileModal.getEmail(),
                    profileModal.getPassword()
            );

            ProfileModal profileModalResponse = profileResponse.get(0);
            if (profileModalResponse.getEmail() == null || profileModalResponse.getPassword() == null) {
                return ApiResponse.builder().code(NO_DATA_FOUND_CODE).message(NO_DATA_FOUND_MESSAGE).build();
            }
               List<ProfileModal> response = profileRepo.fetchProfileByEmail(profileModalResponse.getEmail());
            if (response == null || response.isEmpty()) {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }else
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(response).build();


        }catch (Exception e){
            System.out.println(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }
}
