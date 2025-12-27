package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
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

        Ticket base = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new NotFoundException("Ticket not found"));

        List<DuplicateRule> rules = ruleRepository.findAll();
        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");

        List<DuplicateDetectionLog> results = new ArrayList<>();

        for (DuplicateRule rule : rules) {
            for (Ticket candidate : openTickets) {

                if (candidate.getId().equals(base.getId())) continue;

                double score = 0.0;
                boolean isDuplicate = false;

                switch (rule.getMatchType()) {
                    case "EXACT_MATCH":
                        if (base.getSubject().equalsIgnoreCase(candidate.getSubject())) {
                            score = 1.0;
                            isDuplicate = true;
                        }
                        break;

                    case "KEYWORD":
                        String[] b = (base.getSubject() + " " + base.getDescription())
                                .toLowerCase().split("\\W+");
                        String[] c = (candidate.getSubject() + " " + candidate.getDescription())
                                .toLowerCase().split("\\W+");

                        int common = 0;
                        for (String x : b)
                            for (String y : c)
                                if (!x.isBlank() && x.equals(y)) common++;

                        score = (double) common / Math.max(1, b.length);
                        isDuplicate = score >= rule.getThreshold();
                        break;

                    case "SIMILARITY":
                        score = TextSimilarityUtil.similarity(
                                base.getDescription(),
                                candidate.getDescription()
                        );
                        isDuplicate = score >= rule.getThreshold();
                        break;
                }

                if (isDuplicate) {
                    DuplicateDetectionLog log =
                            new DuplicateDetectionLog(base, candidate, score);
                    log.setDetectedAt(LocalDateTime.now());
                    logRepository.save(log);
                    results.add(log);
                }
            }
        }

        return results;
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Log not found"));
    }
}