package com.mohan.todo_full_stack_app.DTOs.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDTO {
    private String userName;
    private String userEmail;
    private String userPassword;
}
