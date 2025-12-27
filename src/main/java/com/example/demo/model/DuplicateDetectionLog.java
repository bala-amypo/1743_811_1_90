package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DuplicateDetectionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    private boolean duplicateFound;

    public DuplicateDetectionLog() {}

    public DuplicateDetectionLog(Ticket ticket, boolean duplicateFound) {
        this.ticket = ticket;
        this.duplicateFound = duplicateFound;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public boolean isDuplicateFound() { return duplicateFound; }
    public void setDuplicateFound(boolean duplicateFound) { this.duplicateFound = duplicateFound; }
}
