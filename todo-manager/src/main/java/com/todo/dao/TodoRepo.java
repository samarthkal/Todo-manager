package com.todo.dao;

import com.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo,Integer> {
}
