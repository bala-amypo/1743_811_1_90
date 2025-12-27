package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository logRepository;
    private final TicketRepository ticketRepository;

    @Override
    public DuplicateDetectionLog detectDuplicate(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
        // Dummy logic: mark duplicate false
        DuplicateDetectionLog log = new DuplicateDetectionLog();
        log.setTicket(ticket);
        log.setDuplicateFound(false);
        return logRepository.save(log);
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicketIdIn(List.of(ticketId));
    }
}
