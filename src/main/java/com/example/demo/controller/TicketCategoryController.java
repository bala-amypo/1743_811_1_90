package com.example.demo.controller;

import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class TicketCategoryController {

    @Autowired
    private TicketCategoryRepository categoryRepository;

    @GetMapping
    public List<TicketCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TicketCategory> getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id);
    }

    @PostMapping
    public TicketCategory createCategory(@RequestBody TicketCategory category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public TicketCategory updateCategory(@PathVariable Long id, @RequestBody TicketCategory category) {
        category.setId(id);
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
