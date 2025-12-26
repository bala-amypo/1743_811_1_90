package com.example.demo.service.impl;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository ruleRepository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public Optional<DuplicateRule> getRuleById(Long id) {
        return ruleRepository.findById(id);
    }

    @Override
    public DuplicateRule saveRule(DuplicateRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }
}
