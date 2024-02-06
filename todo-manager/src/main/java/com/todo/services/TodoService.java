package com.todo.services;

import com.todo.models.Todo;

import java.util.List;

public interface TodoService {

    public Todo creatTodo(Todo todo);
    public List<Todo> getAllTodo();
    public Todo getTodo(int todoId);
    public Todo updateTodo(int todoId, Todo todo);
    public void deleteTodo(int todoId);
}
