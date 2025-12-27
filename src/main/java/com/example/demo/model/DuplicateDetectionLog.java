package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_logs")
public class DuplicateDetectionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;
    private String message;
    private LocalDateTime detectedAt;

    public DuplicateDetectionLog() {}

    public DuplicateDetectionLog(Long id, Long ticketId, String message, LocalDateTime detectedAt) {
        this.id = id;
        this.ticketId = ticketId;
        this.message = message;
        this.detectedAt = detectedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }

    @Override
    public String toString() {
        return "DuplicateDetectionLog{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", message='" + message + '\'' +
                ", detectedAt=" + detectedAt +
                '}';
    }
}
