package com.mohan.todo_full_stack_app.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Task extends BaseModel {
    private String taskName;
    private String taskDescription;
    @Enumerated(value = EnumType.STRING)
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
