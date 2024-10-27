package com.example.demo.service;


import com.example.demo.model.Cat;
import com.example.demo.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    @Autowired
    private CatRepository catRepository;

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public Optional<Cat> findById(Long id) {
        return catRepository.findById(id);
    }

    public void saveCat(Cat cat) {
        catRepository.save(cat);
    }
}
