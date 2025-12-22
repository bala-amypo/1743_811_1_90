package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DuplicateRule;

import java.util.Optional;

public interface DuplicateRuleRepository extends JpaRepository<DuplicateRule, Long> {
    Optional<DuplicateRule> findByRuleName(String name);
}