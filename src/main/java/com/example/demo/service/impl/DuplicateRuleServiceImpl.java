package com.example.demo.service.impl;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository repository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
        if (repository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists");
        }
        return repository.save(rule);
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public DuplicateRule getRule(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Rule not found")
        );
    }
}
