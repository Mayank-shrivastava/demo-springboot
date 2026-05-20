package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.schema.Todo;
import com.example.demo.services.TodoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        // Logic to retrieve all todos
        return todoService.getAllTodos();
    }

    // add a new todo
    @PostMapping
    public Todo createATodo(@RequestBody Todo todo) {
        // Logic to create a new todo
        return todoService.createTodo(todo);
    }

    // update a  todo
    @PutMapping("/{id}")
    public Todo updateATodo(@PathVariable String id, @RequestBody Todo todo) {
        // Logic to update a todo
        return todoService.updateTodo(id, todo);
    }
    
    // delete a todo
    @DeleteMapping("/{id}")
    public void deleteATodo(@PathVariable String id) {
        // Logic to delete a todo
        todoService.deleteTodo(id);
    }
}
