package com.mohan.todo_full_stack_app.Repositories;


import com.mohan.todo_full_stack_app.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
