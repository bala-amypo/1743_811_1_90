// Implementation
package com.example.demo.service.impl;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TicketService;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepo;
    private final UserRepository userRepo;
    private final TicketCategoryRepository catRepo;

    public TicketServiceImpl(TicketRepository ticketRepo, UserRepository userRepo, TicketCategoryRepository catRepo) {
        this.ticketRepo = ticketRepo;
        this.userRepo = userRepo;
        this.catRepo = catRepo;
    }

    @Override
    public Ticket createTicket(Long userId, Long categoryId, Ticket ticket) {
        if (ticket.getDescription() == null || ticket.getDescription().length() < 10) {
            throw new IllegalArgumentException("Message must contain description");
        }
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        TicketCategory cat = catRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        
        ticket.setUser(user);
        ticket.setCategory(cat);
        if (ticket.getStatus() == null) ticket.setStatus("OPEN");
        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket getTicket(Long ticketId) {
        return ticketRepo.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("ticket not found"));
    }

    @Override
    public List<Ticket> getTicketsByUser(Long userId) {
        return ticketRepo.findByUser_Id(userId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }
}