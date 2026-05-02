package com.mohan.todo_full_stack_app.Repositories;

import com.mohan.todo_full_stack_app.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
