package com.internship2025.changemanagementsystem.Controller;


import com.internship2025.changemanagementsystem.Modal.ApiResponse;
import com.internship2025.changemanagementsystem.Modal.LoginUser;
import com.internship2025.changemanagementsystem.Modal.UsersModel;
import com.internship2025.changemanagementsystem.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/")
public class UsersController {

    public  final UserService usersService;

    public UsersController(UserService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("findUsers")
    public ApiResponse<?> findUsers(){
       return usersService.findUsers();
    }

    @PostMapping("login")
    public ApiResponse<?> login(@RequestBody LoginUser request){
        return  usersService.login(request);
   }

    @PostMapping("saveUsers")
    public ApiResponse<?> saveUsers(@RequestBody UsersModel user) {
      return   usersService.saveUsers(user);
    }

    @PostMapping("validateLogin")
    public ApiResponse<?> validateLogin(@RequestBody UsersModel user) {

        return usersService.validateLogin(user);
    }

    @PostMapping("searchUser")
    public ApiResponse<?> searchUser(@RequestBody UsersModel user) {
        return usersService.searchUsers(user);
    }



}
