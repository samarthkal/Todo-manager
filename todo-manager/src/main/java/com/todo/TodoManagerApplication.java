package com.todo;

import com.todo.dao.TodoDao;
import com.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {
	Logger logger= LoggerFactory.getLogger(TodoDao.class);


	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Application Started....!!");


	}
}
