package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.DuplicateRule;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository logRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final TicketRepository ticketRepository;

    public DuplicateDetectionServiceImpl(
            DuplicateDetectionLogRepository logRepository,
            DuplicateRuleRepository ruleRepository,
            TicketRepository ticketRepository) {
        this.logRepository = logRepository;
        this.ruleRepository = ruleRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public DuplicateDetectionLog detectDuplicate(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        DuplicateRule rule = ruleRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No duplicate rule found"));

        DuplicateDetectionLog log = new DuplicateDetectionLog();
        log.setTicketId(ticket.getId());
        log.setRuleName(rule.getRuleName());
        log.setDuplicateFound(false); // simple default logic
        log.setCheckedAt(LocalDateTime.now());

        return logRepository.save(log);
    }

    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }
}
