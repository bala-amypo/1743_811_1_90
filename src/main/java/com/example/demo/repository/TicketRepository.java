package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCategory_Id(Long id);
    List<Ticket> findByUser_Id(Long id);
    List<Ticket> findByStatus(String status);
    
    // Required for keyword-based duplicate searching
    List<Ticket> findBySubjectContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String subject, String description);
}