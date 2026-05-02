package com.mohan.todo_full_stack_app.DTOs.TaskDTO;

import lombok.Data;

@Data
public class CreateTaskRequestDTO {
    private long userId;
    private String taskName;
    private String taskDescription;
}
