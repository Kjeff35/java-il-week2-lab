package org.example.controllers;

import jakarta.validation.Valid;
import org.example.dtos.TodoRequest;
import org.example.models.ToDo;
import org.example.services.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public String listTodos(Model model) {
        toDoService.findAllTodos(model);
        return "todo-list";
    }

    @PostMapping("/add")
    public String addTodo(@Valid @ModelAttribute TodoRequest request, RedirectAttributes redirectAttributes) {
        toDoService.addTodos(request, redirectAttributes);
        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String completeTodo(@PathVariable Long id) {
        toDoService.markAsComplete(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editToDoForm(@PathVariable Long id, Model model) {
        toDoService.editToDoForm(id, model);
        return "todo-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateToDo(@PathVariable Long id, @Valid @ModelAttribute TodoRequest request, RedirectAttributes redirectAttributes) {
        toDoService.updateToDoItem(id, request, redirectAttributes);
        return "redirect:/";
    }
}
