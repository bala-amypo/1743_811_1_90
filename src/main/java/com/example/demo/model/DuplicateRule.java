package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DuplicateRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    public DuplicateRule() {}
    public DuplicateRule(String ruleName) { this.ruleName = ruleName; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
}
