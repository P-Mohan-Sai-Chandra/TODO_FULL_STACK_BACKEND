package com.mohan.todo_full_stack_app.Repositories;


import com.mohan.todo_full_stack_app.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUser_Id(long id);
}
