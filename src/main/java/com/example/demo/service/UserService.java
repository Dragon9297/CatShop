package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByNameAndPassword(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user.orElse(null);
    }
}
