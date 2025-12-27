package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository repository;

    public DuplicateDetectionServiceImpl(DuplicateDetectionLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        // For now, simply return existing logs for the ticket
        return repository.findByTicket_Id(ticketId);
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return repository.findByTicket_Id(ticketId);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Duplicate log not found")
        );
    }
}
