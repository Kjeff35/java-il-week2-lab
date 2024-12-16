package org.example.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TodoRequest(
        @NotBlank(message = "title is required") String title,
        @FutureOrPresent(message = "Due date must not be in the past") LocalDate dueDate,
        Boolean completed
) {
}
