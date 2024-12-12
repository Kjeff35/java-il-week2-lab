package org.example.controllers;

import org.example.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String welcome(){
        return "welcome";
    }

    @PostMapping
    public String welcomePost(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "greeting";
    }
}
