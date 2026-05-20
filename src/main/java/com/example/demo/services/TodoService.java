package com.example.demo.services;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.ITodoRepository;
import com.example.demo.schema.Todo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Service
//@AllArgsConstructor
public class TodoService {

    private final ITodoRepository todoRepository;

    // public TodoService(@Qualifier("inMemMap") ITodoRepository todoRepository) {  // Todo: Try to fetch the string value from the env variable and use it here
    //     this.todoRepository = todoRepository;
    // }

    // Solution for todo
    public TodoService(
        Map<String, ITodoRepository> repositories, 

        @Value("${todo.repository}") String repositoryName) {
        
            this.todoRepository = repositories.get(repositoryName);

            if (this.todoRepository == null) {
                throw new IllegalArgumentException("No repository found with name: " + repositoryName);
            }
    }

    public List<Todo> getAllTodos() {
        // Logic to retrieve all todos
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo) {
        // Logic to create a new todo
        return todoRepository.save(todo);
    }

    public Todo updateTodo(String id, Todo todo) {
        return todoRepository.update(id, todo);
    }

    public void deleteTodo(String id) {
        todoRepository.delete(id);
    }
}
