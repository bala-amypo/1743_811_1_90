package com.example.demo.controller;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/duplicate-rules")
public class DuplicateRuleController {

    @Autowired
    private DuplicateRuleRepository duplicateRuleRepository;

    @GetMapping
    public List<DuplicateRule> getAllRules() {
        return duplicateRuleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DuplicateRule> getRuleById(@PathVariable Long id) {
        return duplicateRuleRepository.findById(id);
    }

    @PostMapping
    public DuplicateRule createRule(@RequestBody DuplicateRule rule) {
        return duplicateRuleRepository.save(rule);
    }

    @PutMapping("/{id}")
    public DuplicateRule updateRule(@PathVariable Long id, @RequestBody DuplicateRule rule) {
        rule.setId(id);
        return duplicateRuleRepository.save(rule);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) {
        duplicateRuleRepository.deleteById(id);
    }
}
