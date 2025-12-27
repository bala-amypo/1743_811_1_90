package com.example.demo.controller;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
@RequiredArgsConstructor
public class DuplicateRuleController {

    private final DuplicateRuleService ruleService;

    @PostMapping
    public ResponseEntity<DuplicateRule> createRule(@RequestBody DuplicateRule rule) {
        return ResponseEntity.ok(ruleService.createRule(rule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuplicateRule> getRule(@PathVariable Long id) {
        return ResponseEntity.ok(ruleService.getRule(id));
    }

    @GetMapping
    public ResponseEntity<List<DuplicateRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.noContent().build();
    }
}
