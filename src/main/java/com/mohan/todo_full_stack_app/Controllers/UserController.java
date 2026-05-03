package com.mohan.todo_full_stack_app.Controllers;

import com.mohan.todo_full_stack_app.DTOs.ResponseStatus;
import com.mohan.todo_full_stack_app.DTOs.UserDTO.UserCreateRequestDTO;
import com.mohan.todo_full_stack_app.DTOs.UserDTO.UserCreateResponseDTO;
import com.mohan.todo_full_stack_app.Models.User;
import com.mohan.todo_full_stack_app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public UserCreateResponseDTO createUser( @RequestBody UserCreateRequestDTO request){
        System.out.printf("Request is " + request);
        UserCreateResponseDTO response = new UserCreateResponseDTO();
        try{
            User user = userService.registerUser(request.getUserName(),request.getUserEmail(),request.getUserPassword());
            response.setUserName(user.getUserName());
            response.setUserEmail(user.getEmail());
            response.setUserId(user.getId());
            response.setStatus(ResponseStatus.SUCCESS);
            return response;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            response.setStatus(ResponseStatus.FAILURE);
            return response;
        }
    }

}
