package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        User user = userService.findByNameAndPassword(username, password);

        if (user != null) {
            session.setAttribute("username", user.getUsername());
            return "redirect:/";
        } else {
            return "redirect:/register";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.saveUser(user);

        session.setAttribute("username", username);
        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "redirect:/";
    }
}

