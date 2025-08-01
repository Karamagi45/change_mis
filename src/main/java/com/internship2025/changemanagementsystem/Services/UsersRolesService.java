package com.internship2025.changemanagementsystem.Services;

import com.internship2025.changemanagementsystem.Interfaces.Constant;
import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.UsersRolesDto;
import com.internship2025.changemanagementsystem.Repostory.UserRolesRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsersRolesService implements Constant {

    private final UserRolesRepo userRolesRepo;

    public UsersRolesService(UserRolesRepo userRolesRepo) {
        this.userRolesRepo = userRolesRepo;
    }

    public ApiResponse<?> createUserRoles(UsersRolesDto usersRolesDto) {
        try {
            boolean userResponse = userRolesRepo.createUserRoles(usersRolesDto);
            if (userResponse) {

                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else  {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error("createUserRoles: ", e);
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> updateUserRoles(UsersRolesDto usersRolesDto) {
        try {
            boolean userResponse = userRolesRepo.updateUserRoles(usersRolesDto);
            if (userResponse) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else   {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }
        }catch (Exception e){

            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> getUserRoles() {
        try {
            List<UsersRolesDto> rolesResponse = userRolesRepo.getAllUserRoles();
            if (rolesResponse != null) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE)
                        .data(rolesResponse).build();
            }else
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
        }catch (Exception e){
            log.error("getUserRoles: ", e);
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

    public ApiResponse<?> deleteUserRoles(UsersRolesDto usersRolesDto) {
        try {
            boolean userResponse = userRolesRepo.deleteUserRoles(usersRolesDto);
            if (userResponse) {
                return ApiResponse.builder().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).build();
            }else  {
                return ApiResponse.builder().code(FAILED_CODE).message(FAILED_MESSAGE).build();
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return ApiResponse.builder().code(EXCEPTION_CODE).message(EXCEPTION_MESSAGE).build();
        }
    }

}
