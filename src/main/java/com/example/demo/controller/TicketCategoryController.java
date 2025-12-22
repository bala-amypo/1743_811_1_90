package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category Management")
public class TicketCategoryController {

    private final TicketCategoryService categoryService;

    public TicketCategoryController(TicketCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public TicketCategory createCategory(@RequestBody TicketCategory category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public List<TicketCategory> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public TicketCategory getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}