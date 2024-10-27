package com.example.demo.controller;


import com.example.demo.model.CartItem;
import com.example.demo.model.Cat;
import com.example.demo.model.User;
import com.example.demo.service.CartService;
import com.example.demo.service.CatService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CatService catService;
    @Autowired
    private UserService userService;

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<CartItem> cartItems = cartService.getCartItems(user);
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long catId,  HttpSession session) {
        String username = (String) session.getAttribute("username");
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cat cat = catService.findById(catId).orElseThrow(() -> new IllegalArgumentException("Cat not found"));
        cartService.addToCart(user, cat);
        return "redirect:/";
    }


    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return "redirect:/cart";
    }
}
