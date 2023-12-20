package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Todo> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Todo getOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @PostMapping
    Todo create(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    @PutMapping("/{id}")
    Todo update(@RequestBody Todo updatedTodo, @PathVariable Long id) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setDescription(updatedTodo.getDescription());
                    return repository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
