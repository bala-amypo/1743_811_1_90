package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    private double matchScore;
    private LocalDateTime detectedAt;

    public DuplicateDetectionLog() {
        this.detectedAt = LocalDateTime.now();
    }

    public DuplicateDetectionLog(Ticket t1, Ticket t2, double score) {
        this.ticket = t1;
        this.matchScore = score;
        this.detectedAt = LocalDateTime.now();
    }

    public double getMatchScore() { return matchScore; }
    public void setMatchScore(double matchScore) { this.matchScore = matchScore; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
}
