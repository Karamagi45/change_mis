package com.internship2025.changemanagementsystem.Controller;

import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.UsersRolesDto;
import com.internship2025.changemanagementsystem.Services.UsersRolesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usersRoles")
public class UserRolesController {

    private final UsersRolesService usersRolesService;

    public UserRolesController(UsersRolesService usersRolesService) {
        this.usersRolesService = usersRolesService;
    }

    @PostMapping("createUserRoles")
    public ApiResponse<?> createUserRoles(@RequestBody UsersRolesDto usersRolesDto) {
        return usersRolesService.createUserRoles(usersRolesDto);
    }

    @PutMapping("updateUserRoles")
    public ApiResponse<?> updateUserRoles(@RequestBody UsersRolesDto usersRolesDto) {
        return usersRolesService.updateUserRoles(usersRolesDto);
    }

    @GetMapping("getUserRoles")
    public ApiResponse<?> getUserRoles() {
        return usersRolesService.getUserRoles();
    }

    @DeleteMapping("deleteUserRoles")
    public ApiResponse<?> deleteUserRoles(@RequestBody UsersRolesDto usersRolesDto) {
        return usersRolesService.deleteUserRoles(usersRolesDto);
    }

}
