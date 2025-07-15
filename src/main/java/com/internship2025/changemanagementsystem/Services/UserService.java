package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.*;
import com.internship2025.changemanagementsystem.Repostory.UsersRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements Constant {

    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }


    public ApiResponse<?> saveUsers(UsersModel user) {
        try {
            boolean results = usersRepo.save(user);
            if (results) {
                log.info("users save successful");
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else {
                log.info("users save failed");
                return ApiResponse.builder().message(FAILED_MESSAGE).build();
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }



    public ApiResponse<?> selectUserByEmail(String email) {
        try {

            UsersModel usersModel = usersRepo.getAllUsers(email);
            if (usersModel != null) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            } else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();

        }catch (Exception e){
            log.error(e.getMessage(), e);
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }

    }


    public ApiResponse<?> login(LoginUser  loginUser) {

        List<LoginUser> response = usersRepo.login(loginUser.getEmail(), loginUser.getPassword());
        if(response == null){
            return ApiResponse.builder().code(99)
                    .message("Incorrect credentials").build();
        } else
            return ApiResponse.builder().code(SUCCESS_CODE).
                    message("Login Successful").build();

    }

    public ApiResponse<?> validateLogin(UsersModel user) {
        try{
            UsersModel responseData = usersRepo.findUserByEmail(user.getEmail());
            if (responseData == null)
                return ApiResponse.builder().code(NO_DATA_FOUND_CODE)
                        .message("Invalid Email").build();
            else
                return ApiResponse.builder().code(SUCCESS_CODE)
                    .message(SUCCESS_MESSAGE).build();

        }catch(Exception e){
            System.out.println(e.getMessage());
            return  ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> findUsers(){
        try {

            List<UsersModel> usersModelList = usersRepo.findAllUsers();

            if(!usersModelList.isEmpty()){
                System.out.println("users find successful");
                return ApiResponse.builder().message(SUCCESS_MESSAGE)
                        .data(usersModelList).build();
            }else {
                System.out.println("users find failed");
                return ApiResponse.builder().message(NO_DATA_FOUND_MESSAGE).build();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            return  ApiResponse.builder().message(EXCEPTION_MESSAGE).build();
        }
    }
    public  Object generateOTP() {
        String otp = "";
        for (int i = 0; i<6; i++) {
            otp += (int)(Math.random() * 10);
        }
        System.out.println("otp generated: " + otp);
        return otp;
    }


}
