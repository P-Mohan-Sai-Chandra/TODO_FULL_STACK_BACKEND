package com.mohan.todo_full_stack_app.DTOs.TaskDTO;

import com.mohan.todo_full_stack_app.DTOs.ResponseStatus;
import com.mohan.todo_full_stack_app.Models.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTasksResponseDTO {
    private ResponseStatus status;
    private List<Task> tasks;
}
