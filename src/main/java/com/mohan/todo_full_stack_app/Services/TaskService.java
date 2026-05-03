package com.mohan.todo_full_stack_app.Services;

import com.mohan.todo_full_stack_app.Models.Task;
import com.mohan.todo_full_stack_app.Models.TaskMilestone;
import com.mohan.todo_full_stack_app.Models.TaskStatus;

import java.util.List;

public interface TaskService {

    Task createTask(long userId,String taskName,String taskDescription) throws Exception;
    Task changeStatus(long userId, long taskId,String newStatus) throws Exception;
    TaskMilestone createMileStone(long userId, long taskId, String mileStoneDescription) throws Exception;
    Task deleteTask(long userId,long taskId) throws Exception;
    TaskMilestone updateMilestone(long userId,long milestoneId,String mileStoneDescription) throws Exception;
    TaskMilestone deleteMilestone(long userId,long milestoneId) throws Exception;
    List<Task> getAllTasks(long userId) throws Exception;

}
