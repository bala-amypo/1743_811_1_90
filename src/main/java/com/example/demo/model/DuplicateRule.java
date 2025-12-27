package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "duplicate_rules")
public class DuplicateRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String description;

    public DuplicateRule() {}

    public DuplicateRule(Long id, String ruleName, String description) {
        this.id = id;
        this.ruleName = ruleName;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "DuplicateRule{" +
                "id=" + id +
                ", ruleName='" + ruleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
