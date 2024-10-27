package com.example.demo.service;



import com.example.demo.model.CartItem;
import com.example.demo.model.Cat;
import com.example.demo.model.User;
import com.example.demo.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItems(User user) {
        return cartItemRepository.findByUser(user);
    }

    public void addToCart(User user, Cat cat) {
        CartItem cartItem = new CartItem();
        cartItem.setUser(user);
        cartItem.setCat(cat);
        cartItemRepository.save(cartItem);
    }

    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
