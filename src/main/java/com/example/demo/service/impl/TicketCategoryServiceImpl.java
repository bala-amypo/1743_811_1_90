package com.example.demo.service.impl;

import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketCategoryServiceImpl implements TicketCategoryService {

    private final TicketCategoryRepository repository;

    @Override
    public TicketCategory createCategory(TicketCategory category) {
        return repository.save(category);
    }

    @Override
    public TicketCategory getCategory(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<TicketCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
