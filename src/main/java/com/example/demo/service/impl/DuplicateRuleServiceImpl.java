// Implementation
package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;

import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {
    private final DuplicateRuleRepository ruleRepo;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
        if (ruleRepo.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Rule exists");
        }
        if (rule.getThreshold() < 0 || rule.getThreshold() > 1) {
            throw new IllegalArgumentException("Invalid threshold");
        }
        return ruleRepo.save(rule);
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return ruleRepo.findAll();
    }

    @Override
    public DuplicateRule getRule(Long id) {
        return ruleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }
}