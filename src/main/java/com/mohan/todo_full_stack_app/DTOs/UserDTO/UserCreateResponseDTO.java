package com.mohan.todo_full_stack_app.DTOs.UserDTO;

import com.mohan.todo_full_stack_app.DTOs.ResponseStatus;
import com.mohan.todo_full_stack_app.Models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponseDTO {
    private ResponseStatus status;
    private long userId;
    private String userName;
    private String userEmail;
}
