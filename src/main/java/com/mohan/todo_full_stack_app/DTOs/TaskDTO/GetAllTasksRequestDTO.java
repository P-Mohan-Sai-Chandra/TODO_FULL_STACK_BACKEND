package com.mohan.todo_full_stack_app.DTOs.TaskDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTasksRequestDTO {
    private long userId;
}


