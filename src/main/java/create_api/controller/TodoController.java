package create_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import create_api.Repository.TodoRepository;
import create_api.model.Todo;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository repository;

    @PostMapping
    public String create(@RequestParam("task") String task) {
        Todo todo = new Todo(null, task, "", false);
        repository.save(todo);
        return "redirect:/todos";
    }

}
