package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;

import java.util.ArrayList;
import java.util.List;

public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepository,
            DuplicateRuleRepository ruleRepository,
            DuplicateDetectionLogRepository logRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket base = ticketRepository.findById(ticketId).orElseThrow();
        List<DuplicateRule> rules = ruleRepository.findAll();
        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");

        List<DuplicateDetectionLog> results = new ArrayList<>();

        for (Ticket other : openTickets) {
            if (other.getId() != null && other.getId().equals(base.getId())) continue;

            for (DuplicateRule rule : rules) {

                double score = 0.0;

                if ("EXACT_MATCH".equals(rule.getMatchType())) {
                    if (base.getSubject() != null &&
                        base.getSubject().equalsIgnoreCase(other.getSubject())) {
                        score = 1.0;
                    }
                }

                if ("KEYWORD".equals(rule.getMatchType())
                        || "SIMILARITY".equals(rule.getMatchType())) {

                    score = TextSimilarityUtil.similarity(
                            base.getSubject() + " " + base.getDescription(),
                            other.getSubject() + " " + other.getDescription()
                    );
                }

                if (score >= rule.getThreshold()) {
                    DuplicateDetectionLog log =
                            new DuplicateDetectionLog(base, other, score);
                    results.add(logRepository.save(log));
                }
            }
        }
        return results;
    }

    // ✅ Alias for controller
    @Override
    public List<DuplicateDetectionLog> detectDuplicate(Long ticketId) {
        return detectDuplicates(ticketId);
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
