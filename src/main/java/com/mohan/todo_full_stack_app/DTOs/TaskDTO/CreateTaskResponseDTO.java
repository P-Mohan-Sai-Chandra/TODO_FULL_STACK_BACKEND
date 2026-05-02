package com.mohan.todo_full_stack_app.DTOs.TaskDTO;

import com.mohan.todo_full_stack_app.DTOs.ResponseStatus;
import com.mohan.todo_full_stack_app.Models.Task;
import com.mohan.todo_full_stack_app.Models.TaskStatus;
import lombok.Data;

@Data
public class CreateTaskResponseDTO {
    private ResponseStatus status;
    private Task task;
}
