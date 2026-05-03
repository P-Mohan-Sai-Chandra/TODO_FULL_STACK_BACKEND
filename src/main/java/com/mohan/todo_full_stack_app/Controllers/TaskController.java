package com.mohan.todo_full_stack_app.Controllers;

import com.mohan.todo_full_stack_app.DTOs.ResponseStatus;
import com.mohan.todo_full_stack_app.DTOs.TaskDTO.CreateTaskRequestDTO;
import com.mohan.todo_full_stack_app.DTOs.TaskDTO.CreateTaskResponseDTO;
import com.mohan.todo_full_stack_app.DTOs.TaskDTO.GetAllTasksRequestDTO;
import com.mohan.todo_full_stack_app.DTOs.TaskDTO.GetAllTasksResponseDTO;
import com.mohan.todo_full_stack_app.Models.Task;
import com.mohan.todo_full_stack_app.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
       this.taskService = taskService;
    }

    @PostMapping("/task")
    public CreateTaskResponseDTO createTask(@RequestBody  CreateTaskRequestDTO request){
        CreateTaskResponseDTO response = new CreateTaskResponseDTO();
        try{
            Task task = taskService.createTask(request.getUserId(),request.getTaskName(),request.getTaskDescription());
            response.setCreatedAt(task.getCreatedAt());
            response.setUpdatedAt(task.getUpdatedAt());
            response.setTaskId(task.getId());
            response.setTaskName(task.getTaskName());
            response.setUser_id(task.getUser().getId());
            response.setStatus(ResponseStatus.SUCCESS);
            return response;
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            return response;
        }
    }

    @GetMapping("/tasks/{id}")
    public GetAllTasksResponseDTO getAllTasks(@PathVariable(name = "id") long id){
        GetAllTasksResponseDTO response = new GetAllTasksResponseDTO();
        try{
            List<Task> tasks = taskService.getAllTasks(id);
            response.setTasks(tasks);
            response.setStatus(ResponseStatus.SUCCESS);
            return response;
        }
        catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            return response;
        }
    }



}
