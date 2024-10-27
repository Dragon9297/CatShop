package com.example.demo.controller;


import com.example.demo.model.Cat;
import com.example.demo.service.CatService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CatController {
    @Autowired
    private CatService catService;

    @GetMapping("/")
    public String viewHomePage(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");

        List<Cat> cats = catService.findAll();
        model.addAttribute("cats", cats);
        model.addAttribute("isLoggedIn", username != null);
        return "index";
    }

    @PostMapping("/add-cat")
    public String addCat(Cat cat) {
        catService.saveCat(cat);
        return "redirect:/";
    }

    @GetMapping("/add-cat")
    public String viewAddCat(Model model) {

        return "/add-cat";
    }
}
