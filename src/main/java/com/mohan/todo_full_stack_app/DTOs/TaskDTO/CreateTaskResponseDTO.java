package com.mohan.todo_full_stack_app.DTOs.TaskDTO;

import com.mohan.todo_full_stack_app.DTOs.ResponseStatus;
import com.mohan.todo_full_stack_app.Models.Task;
import com.mohan.todo_full_stack_app.Models.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskResponseDTO {
    private ResponseStatus status;
    private long taskId;
    private String taskName;
    private long user_id;
    private Date createdAt;
    private Date updatedAt;

}
