package com.example.demo.service;

import com.example.demo.model.Ticket;
import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> getAllTickets();
    Optional<Ticket> getTicketById(Long id);
    Ticket saveTicket(Ticket ticket);
    void deleteTicket(Long id);
}
