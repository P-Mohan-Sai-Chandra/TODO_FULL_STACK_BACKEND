package com.mohan.todo_full_stack_app.Controllers;

import com.mohan.todo_full_stack_app.DTOs.ResponseStatus;
import com.mohan.todo_full_stack_app.DTOs.TaskDTO.CreateTaskRequestDTO;
import com.mohan.todo_full_stack_app.DTOs.TaskDTO.CreateTaskResponseDTO;
import com.mohan.todo_full_stack_app.Models.Task;
import com.mohan.todo_full_stack_app.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
       this.taskService = taskService;
    }

    @PostMapping("/task")
    public CreateTaskResponseDTO createTask(CreateTaskRequestDTO request){
        CreateTaskResponseDTO response = new CreateTaskResponseDTO();
        try{
            Task task = taskService.createTask(request.getUserId(),request.getTaskName(),request.getTaskDescription());
            response.setTask(task);
            response.setStatus(ResponseStatus.SUCCESS);
            return response;
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            return response;
        }
    }



}
