package com.example.demo.service;

import com.example.demo.model.DuplicateRule;

public interface DuplicateRuleService {
    List<DuplicateRule> getAllRules();  // 🔥 ADD

    void deleteRule(Long id);
    DuplicateRule createRule(DuplicateRule rule);

    DuplicateRule getRule(Long id);
}
