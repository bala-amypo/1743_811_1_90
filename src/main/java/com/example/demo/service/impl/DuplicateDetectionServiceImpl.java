package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository duplicateDetectionLogRepository;

    // Constructor as expected by test cases
    public DuplicateDetectionServiceImpl(DuplicateDetectionLogRepository duplicateDetectionLogRepository) {
        this.duplicateDetectionLogRepository = duplicateDetectionLogRepository;
    }

    @Override
    public DuplicateDetectionLog logDuplicate(DuplicateDetectionLog log) {
        return duplicateDetectionLogRepository.save(log);
    }

    @Override
    public Optional<DuplicateDetectionLog> getLogById(Long id) {
        return duplicateDetectionLogRepository.findById(id);
    }

    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return duplicateDetectionLogRepository.findAll();
    }

    @Override
    public void deleteLog(Long id) {
        duplicateDetectionLogRepository.deleteById(id);
    }
}
