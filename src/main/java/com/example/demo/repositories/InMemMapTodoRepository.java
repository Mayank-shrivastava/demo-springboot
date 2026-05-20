package com.example.demo.repositories;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.schema.Todo;

@Repository("inMemMap")
// @Profile("prod")
// @Repository("inMemMap")
// @Qualifier("inMemMap")
// @Primary
public class InMemMapTodoRepository implements ITodoRepository {
    private Map<String, Todo> todos = new HashMap<>();

    public InMemMapTodoRepository() {
        todos.put("1", new Todo("1", "Buy groceries"));
        todos.put("2", new Todo("2", "Walk the dog from map"));
        todos.put("3", new Todo("3", "Finish homework"));
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    @Override
    public Todo save(Todo todo) {
        todos.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public Todo update(String id, Todo todo) {
        for (String key : todos.keySet()) {
            if (key.equals(id)) {
                todos.put(key, todo);
                return todo;
            }
        }

        throw new IllegalArgumentException("Todo with id " + id + " not found");
    }

    @Override
    public void delete(String id) {
        todos.remove(id);
    }
}
