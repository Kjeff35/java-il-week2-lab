package org.example.services;

import org.example.dtos.TodoRequest;
import org.example.models.ToDo;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ToDoService {
    void findAllTodos(Model model);

    void addTodos(TodoRequest request, RedirectAttributes redirectAttributes);

    void markAsComplete(Long id);

    void editToDoForm(Long id, Model model);

    void updateToDoItem(Long id, TodoRequest request, RedirectAttributes redirectAttributes);
}
