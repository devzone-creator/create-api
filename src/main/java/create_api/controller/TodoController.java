package create_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import create_api.dto.CreateTodoRequest;

import create_api.Repository.TodoRepository;
import create_api.model.Todo;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository repository;

    @PostMapping
    public ResponseEntity<Todo> create(@Valid @RequestBody CreateTodoRequest request){
        Todo todo = new Todo(null, request.title(), request.description(), false);
        Todo saved = repository.save(todo);
        return ResponseEntity.status(200).body(saved);
    }

}
