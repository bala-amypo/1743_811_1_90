package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository duplicateDetectionLogRepository;

    // Constructor matching the tests
    public DuplicateDetectionServiceImpl(DuplicateDetectionLogRepository duplicateDetectionLogRepository) {
        this.duplicateDetectionLogRepository = duplicateDetectionLogRepository;
    }

    @Override
    public DuplicateDetectionLog logDuplicate(DuplicateDetectionLog log) {
        return duplicateDetectionLogRepository.save(log);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return duplicateDetectionLogRepository.findById(id).orElse(null);
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
