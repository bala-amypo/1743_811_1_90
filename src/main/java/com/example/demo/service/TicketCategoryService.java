package com.example.demo.service;

import com.example.demo.model.TicketCategory;
import java.util.List;
import java.util.Optional;

public interface TicketCategoryService {
    List<TicketCategory> getAllCategories();
    Optional<TicketCategory> getCategoryById(Long id);
    TicketCategory saveCategory(TicketCategory category);
    void deleteCategory(Long id);
}
