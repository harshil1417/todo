package com.harshil.todo;

import com.harshil.todo.model.Todo;
import com.harshil.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private TodoRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		List<Todo> todos = Arrays.asList(
				new Todo("Need to get Milk", false),
				new Todo("Meeting with John", false),
				new Todo("Call David", false),
				new Todo("Email reply to Linda", false),
				new Todo("Get some flowers", false),
				new Todo("Order Shoes on Amazon", false),
				new Todo("Email reply to XYZ", true)
		);

		todos.forEach(todo ->
				repository.save(todo)
		);

	}
}
