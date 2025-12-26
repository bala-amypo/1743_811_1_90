package com.example.demo.service;

import com.example.demo.model.DuplicateRule;
import java.util.List;
import java.util.Optional;

public interface DuplicateRuleService {
    List<DuplicateRule> getAllRules();
    Optional<DuplicateRule> getRuleById(Long id);
    DuplicateRule saveRule(DuplicateRule rule);
    void deleteRule(Long id);
}
