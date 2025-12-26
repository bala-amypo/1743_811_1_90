package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;

@Service
public class DuplicateDetectionServiceImpl
        implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository repository;

    public DuplicateDetectionServiceImpl(
            DuplicateDetectionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public DuplicateDetectionLog detectDuplicates(Long ticketId) {

        DuplicateDetectionLog log = new DuplicateDetectionLog();
        log.setTicketId(ticketId);
        log.setDuplicate(true);
        log.setRuleName("BASIC_RULE");
        log.setCreatedAt(System.currentTimeMillis());

        return repository.save(log);
    }
}
