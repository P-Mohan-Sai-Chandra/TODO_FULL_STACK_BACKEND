package com.mohan.todo_full_stack_app.Repositories;

import com.mohan.todo_full_stack_app.Models.TaskMilestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskMilestoneRepository extends JpaRepository<TaskMilestone,Long> {
}
