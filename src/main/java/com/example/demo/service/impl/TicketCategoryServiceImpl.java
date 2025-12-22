// Implementation
package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketCategoryService;

import java.util.List;

@Service
public class TicketCategoryServiceImpl implements TicketCategoryService {
    private final TicketCategoryRepository categoryRepository;

    public TicketCategoryServiceImpl(TicketCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public TicketCategory createCategory(TicketCategory category) {
        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new IllegalArgumentException("Message must contain category exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<TicketCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public TicketCategory getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
}