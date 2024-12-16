package org.example.services.impl;

import org.example.dtos.TodoRequest;
import org.example.exceptions.RedirectToHomeException;
import org.example.models.ToDo;
import org.example.repositories.ToDoRepository;
import org.example.services.ToDoService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void findAllTodos(Model model) {
        model.addAttribute("todos", toDoRepository.findAll());
    }

    @Override
    public void addTodos(TodoRequest request, RedirectAttributes redirectAttributes) {
        ToDo todo = new ToDo();
        todo.setTitle(request.title());
        todo.setDueDate(request.dueDate());
        todo.setCompleted(false);
        toDoRepository.save(todo);
        redirectAttributes.addFlashAttribute("message", "ToDo item added successfully!");
    }

    @Override
    public void markAsComplete(Long id) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new RedirectToHomeException("Todo item not found"));
        todo.setCompleted(true);
        toDoRepository.save(todo);
    }

    @Override
    public void editToDoForm(Long id, Model model) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new RedirectToHomeException("Todo item not found"));
        model.addAttribute("todo", todo);
    }

    @Override
    public void updateToDoItem(Long id, TodoRequest request, RedirectAttributes redirectAttributes) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new RedirectToHomeException("Todo item not found"));
        todo.setTitle(request.title());
        todo.setDueDate(request.dueDate());
        todo.setCompleted(request.completed() != null && request.completed());
        toDoRepository.save(todo);
        redirectAttributes.addFlashAttribute("message", "ToDo updated successfully!");
    }
}
