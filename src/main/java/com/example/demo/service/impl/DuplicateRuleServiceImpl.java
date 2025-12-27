package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository ruleRepository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {

        if (ruleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("exists");
        }

        if (rule.getThreshold() < 0.0 || rule.getThreshold() > 1.0) {
            throw new IllegalArgumentException("Invalid threshold");
        }

        if (rule.getCreatedAt() == null) {
            rule.setCreatedAt(LocalDateTime.now());
        }

        return ruleRepository.save(rule);
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public DuplicateRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rule not found"));
    }
}