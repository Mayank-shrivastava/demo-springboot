package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.ITodoRepository;
import com.example.demo.schema.Todo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {

    private final ITodoRepository todoRepository;

    // public TodoService(@Qualifier("inMemMap") ITodoRepository todoRepository) {
    //     this.todoRepository = todoRepository;
    // }

    public List<Todo> getAllTodos() {
        // Logic to retrieve all todos
        return todoRepository.findAll();
    }
}
