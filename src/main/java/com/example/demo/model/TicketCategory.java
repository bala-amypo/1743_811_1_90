package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private TicketCategory category;

    @ManyToOne
    private User createdBy;

    public Ticket() {}

    public Ticket(Long id, String title, String description, TicketCategory category, User createdBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.createdBy = createdBy;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TicketCategory getCategory() { return category; }
    public void setCategory(TicketCategory category) { this.category = category; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category=" + (category != null ? category.getName() : null) +
                ", createdBy=" + (createdBy != null ? createdBy.getUsername() : null) +
                '}';
    }
}
