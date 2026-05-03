package com.mohan.todo_full_stack_app.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User extends BaseModel {
    private String userName;
    @Column(unique = true)
    private String email;
    @JsonIgnore
    private String currentPassword;
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;
}

