package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private TicketCategory category;

    private String subject;

    @Column(length = 2000)
    private String description;

    private String status = "OPEN";

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ticket")
    private List<DuplicateDetectionLog> baseLogs;

    @OneToMany(mappedBy = "matchedTicket")
    private List<DuplicateDetectionLog> matchedLogs;

    public Ticket() {}

    @PrePersist
    public void onCreate() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (status == null) status = "OPEN";
    }

    // ---- getters & setters ----

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public TicketCategory getCategory() { return category; }
    public void setCategory(TicketCategory category) { this.category = category; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<DuplicateDetectionLog> getBaseLogs() { return baseLogs; }
    public void setBaseLogs(List<DuplicateDetectionLog> baseLogs) { this.baseLogs = baseLogs; }

    public List<DuplicateDetectionLog> getMatchedLogs() { return matchedLogs; }
    public void setMatchedLogs(List<DuplicateDetectionLog> matchedLogs) { this.matchedLogs = matchedLogs; }
}