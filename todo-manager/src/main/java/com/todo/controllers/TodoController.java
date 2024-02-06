package com.todo.controllers;

import com.todo.models.Todo;
import com.todo.services.TodoServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Random random=new Random();

    @Autowired
    TodoServicesImpl todoServices;


    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){

         todo.setId(random.nextInt(5555));
        Todo todo1 = this.todoServices.creatTodo(todo);

        return  new ResponseEntity<>(todo1, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodoHandler(){


        List<Todo> all = this.todoServices.getAllTodo();

        return  new ResponseEntity<>(all,HttpStatus.OK);
    }
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo>getTodoHandler(@PathVariable int todoId){

        Todo one = this.todoServices.getTodo(todoId);

        return  new ResponseEntity<>(one,HttpStatus.OK);

    }
    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoHandler(@PathVariable int todoId,@RequestBody Todo newtodo){


        Todo update = this.todoServices.updateTodo(todoId, newtodo);

        return  new ResponseEntity<>(update,HttpStatus.CREATED);

    }
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodoHandler(@PathVariable int todoId){

         this.todoServices.deleteTodo(todoId);

         return ResponseEntity.ok("Todo deleted successfully..");

    }

}
