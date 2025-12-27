package com.example.demo.controller;

import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class TicketCategoryController {

    private final TicketCategoryRepository categoryRepository;

    public TicketCategoryController(TicketCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<TicketCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public TicketCategory createCategory(@RequestBody TicketCategory category) {
        return categoryRepository.save(category);
    }
}
