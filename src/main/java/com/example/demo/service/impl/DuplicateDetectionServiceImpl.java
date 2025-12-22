package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {
    private final TicketRepository ticketRepo;
    private final DuplicateRuleRepository ruleRepo;
    private final DuplicateDetectionLogRepository logRepo;

    public DuplicateDetectionServiceImpl(TicketRepository ticketRepo, DuplicateRuleRepository ruleRepo, DuplicateDetectionLogRepository logRepo) {
        this.ticketRepo = ticketRepo;
        this.ruleRepo = ruleRepo;
        this.logRepo = logRepo;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        Ticket baseTicket = ticketRepo.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("ticket not found"));
        
        List<Ticket> candidates = ticketRepo.findByStatus("OPEN");
        List<DuplicateRule> rules = ruleRepo.findAll();
        List<DuplicateDetectionLog> logs = new ArrayList<>();

        for (Ticket candidate : candidates) {
            
            if (candidate.getId().equals(baseTicket.getId())) continue;

            for (DuplicateRule rule : rules) {
                double score = 0.0;
                
                if ("EXACT_MATCH".equals(rule.getMatchType())) {
                    String s1 = baseTicket.getSubject();
                    String s2 = candidate.getSubject();
                    
                    if (s1 != null && s1.equalsIgnoreCase(s2)) {
                        score = 1.0;
                    }
                } else if ("SIMILARITY".equals(rule.getMatchType())) {
                    score = TextSimilarityUtil.similarity(baseTicket.getDescription(), candidate.getDescription());
                }

                if (score >= rule.getThreshold()) {
                    logs.add(logRepo.save(new DuplicateDetectionLog(baseTicket, candidate, score)));
                }
            }
        }
        return logs;
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepo.findByTicket_Id(ticketId);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }
}