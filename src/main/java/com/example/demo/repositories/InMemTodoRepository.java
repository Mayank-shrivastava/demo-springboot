package com.example.demo.repositories;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.schema.Todo;

@Repository("inMem")
// @Profile("dev")
// @Repository("inMem")
// @Qualifier("inMem")
public class InMemTodoRepository implements ITodoRepository {
    private List<Todo> todos = Arrays.asList(
        new Todo("1", "Buy groceries"),
        new Todo("2", "Walk the dog"),
        new Todo("3", "Finish homework")
    );
    
    public List<Todo> findAll() {
        return todos;
    }

    @Override
    public Todo save(Todo todo) {
        todos.add(todo);
        return todo;
    }

    @Override
    public Todo update(String id, Todo todo) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(id)) {
                todos.set(i, todo);
                return todo;
            }
        }

        throw new IllegalArgumentException("Todo with id " + id + " not found");
    }

    @Override
    public void delete(String id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }
}
