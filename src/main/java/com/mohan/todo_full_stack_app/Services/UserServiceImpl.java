package com.mohan.todo_full_stack_app.Services;

import com.mohan.todo_full_stack_app.Models.User;
import com.mohan.todo_full_stack_app.Models.UserStatus;
import com.mohan.todo_full_stack_app.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements  UserService{

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder(12);
    }

    @Override
    public User changeEmail(long userId, String newEmail) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        user.setEmail(newEmail);
        userRepository.save(user);
        return user;
    }

    @Override
    public User registerUser(String userName, String userEmail, String userPassword) throws Exception {
       User user = new User();
       user.setUserName(userName);
       user.setEmail(userEmail);
       String hashPassword = encoder.encode(userPassword);
       user.setCurrentPassword(hashPassword);
       userRepository.save(user);
        return user;
    }

    @Override
    public User deActivateUser(long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        if(user.getStatus() == UserStatus.IN_ACTIVE) return user;
        user.setStatus(UserStatus.IN_ACTIVE);
        userRepository.save(user);
        return user;
    }

    @Override
    public User reActivateUser(long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        if(user.getStatus() == UserStatus.ACTIVE) return user;
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
        return user;
    }

    @Override
    public User changePassword(long userId, String newPassword) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        String hashPassword = encoder.encode(newPassword);
        user.setCurrentPassword(hashPassword);
        userRepository.save(user);
        return user;
    }

    @Override
    public User changeUserName(long userId, String userName) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        user.setUserName(userName);
        userRepository.save(user);
        return user;
    }
}
