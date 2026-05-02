package com.mohan.todo_full_stack_app.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TaskMilestone extends BaseModel {

    private String description;
    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

}
