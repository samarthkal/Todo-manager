package com.todo.services;

import com.todo.controllers.TodoController;
import com.todo.dao.TodoRepo;
import com.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//@Component
@Service
@Primary
public class TodoServicesImpl implements TodoService {




    Logger logger= LoggerFactory.getLogger(TodoController.class);
    @Autowired
    TodoRepo todoRepo;

    //  create  todo
    @Override
    public Todo creatTodo(Todo todo) {

        todo.setAddedDate(new Date());
        Todo save = todoRepo.save(todo);
        logger.info("Todo Creation: {}",save);

        return save;
    }


    // get all todo
    @Override
    public List<Todo> getAllTodo() {

        List<Todo> all = todoRepo.findAll();

        logger.info("Getting all Todo: {}",all);
        return all;
    }

    // get one todo
    @Override
    public Todo getTodo(int todoId) {

        Optional<Todo> todo = todoRepo.findById(todoId);
        Todo user = todo.orElseThrow();

        logger.info("Get Single Todo: {}",user);

        return user;
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {

        Todo old = todoRepo.findById(todoId).orElseThrow();

        old.setTitle(todo.getTitle());
        old.setStatus(todo.getStatus());
        old.setContent(todo.getContent());
        old.setTodoDate(todo.getTodoDate());
        old.setAddedDate(new Date());

        Todo save = todoRepo.save(old);

        return save;
    }

    @Override
    public void deleteTodo(int todoId) {

        todoRepo.deleteById(todoId);

    }
















}
