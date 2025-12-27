package com.example.demo.service.impl;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository repository;

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
        return repository.save(rule);
    }

    @Override
    public DuplicateRule getRule(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
