package com.mohan.todo_full_stack_app.Services;

import com.mohan.todo_full_stack_app.Models.User;

public interface UserService {

    User registerUser(String userName, String userEmail, String userPassword) throws Exception;
    User deActivateUser(long userId) throws Exception;
    User reActivateUser(long userId) throws Exception;
    User changePassword(long userId,String newPassword) throws Exception;
    User changeEmail(long userId, String newEmail) throws Exception;
    User changeUserName(long user,String userName) throws Exception;

}
