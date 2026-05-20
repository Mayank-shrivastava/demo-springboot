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
}
