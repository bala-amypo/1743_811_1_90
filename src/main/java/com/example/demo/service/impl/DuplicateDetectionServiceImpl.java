package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetection;
import com.example.demo.repository.DuplicateDetectionRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionRepository logRepository;

    public DuplicateDetectionServiceImpl(DuplicateDetectionRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetection> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Optional<DuplicateDetection> getLogById(Long id) {
        return logRepository.findById(id);
    }

    @Override
    public DuplicateDetection saveLog(DuplicateDetection log) {
        return logRepository.save(log);
    }

    @Override
    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }
}
