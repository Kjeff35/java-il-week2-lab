package org.example.exceptions;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RedirectToHomeException.class)
    public String handleRedirectToHomeException(Exception exception, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", exception.getMessage());
        return "redirect:/";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, RedirectAttributes redirectAttributes) {

        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        redirectAttributes.addFlashAttribute("error", errors);

        return "redirect:/";
    }
}
