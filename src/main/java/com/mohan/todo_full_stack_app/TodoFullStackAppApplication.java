package com.mohan.todo_full_stack_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoFullStackAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoFullStackAppApplication.class, args);
	}

}
