package com.mohan.todo_full_stack_app.Services;

import com.mohan.todo_full_stack_app.Models.Task;
import com.mohan.todo_full_stack_app.Models.TaskMilestone;
import com.mohan.todo_full_stack_app.Models.TaskStatus;
import com.mohan.todo_full_stack_app.Models.User;
import com.mohan.todo_full_stack_app.Repositories.TaskMilestoneRepository;
import com.mohan.todo_full_stack_app.Repositories.TaskRepository;
import com.mohan.todo_full_stack_app.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TaskServiceImpl implements  TaskService{

    private TaskRepository taskRepository ;
    private UserRepository userRepository;
    private TaskMilestoneRepository taskMilestoneRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository,UserRepository userRepository,TaskMilestoneRepository taskMilestoneRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskMilestoneRepository = taskMilestoneRepository;
    }

    @Override
    public Task changeStatus(long userId, long taskId, String newStatus) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new Exception("Task Not Found"));
        if(task.getUser().getId() != userId) throw new Exception("Task does not belong to the user");
        task.setStatus(TaskStatus.valueOf(newStatus));
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task createTask(long userId, String taskName, String taskDescription) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        Task task = new Task();
        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setStatus(TaskStatus.OPEN);
        task.setUser(user);
        taskRepository.save(task);
        return task;
    }

    @Override
    public TaskMilestone createMileStone(long userId, long taskId, String mileStoneDescription) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new Exception("Task Not Found"));
        if(task.getUser().getId() != userId) throw new Exception("Task does not belong to the user");
        TaskMilestone mileStone = new TaskMilestone();
        mileStone.setDescription(mileStoneDescription);
        mileStone.setTask(task);
        taskMilestoneRepository.save(mileStone);
        return mileStone;
    }

    @Override
    public Task deleteTask(long userId, long taskId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        Task task = taskRepository.findById(taskId).orElseThrow(()-> new Exception("Task Not Found"));
        if(task.getUser().getId() != userId) throw new Exception("Task does not belong to the user");
        taskRepository.delete(task);
        return task;
    }

    @Override
    public TaskMilestone updateMilestone(long userId, long milestoneId,String mileStoneDescription) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        TaskMilestone milestone = taskMilestoneRepository.findById(milestoneId).orElseThrow(()->new Exception("MileStone not valid"));
        Task task = milestone.getTask();
        if(task.getUser().getId() != userId) throw new Exception("MileStone is not valid");
        milestone.setDescription(mileStoneDescription);
        taskMilestoneRepository.save(milestone);
        return milestone;
    }

    @Override
    public TaskMilestone deleteMilestone(long userId, long milestoneId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
        TaskMilestone milestone = taskMilestoneRepository.findById(milestoneId).orElseThrow(()->new Exception("MileStone not valid"));
        Task task = milestone.getTask();
        if(task.getUser().getId() != userId) throw new Exception("MileStone is not valid");
        taskMilestoneRepository.delete(milestone);
        return milestone;
    }
}
