package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repositories.TodoRepository;
import com.example.demo.schema.Todo;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        // Logic to retrieve all todos
        return todoRepository.findAll();
    }
}
