package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionLogService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DuplicateDetectionLogServiceImpl implements DuplicateDetectionLogService {

    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionLogServiceImpl(DuplicateDetectionLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Optional<DuplicateDetectionLog> getLogById(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public DuplicateDetectionLog saveLog(DuplicateDetectionLog log) {
        return logRepository.save(log);
    }

    @Override
    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}
