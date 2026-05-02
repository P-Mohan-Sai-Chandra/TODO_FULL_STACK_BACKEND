package com.mohan.todo_full_stack_app.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User extends BaseModel {
    private String userName;
    private String email;
    private String currentPassword;
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;
}
