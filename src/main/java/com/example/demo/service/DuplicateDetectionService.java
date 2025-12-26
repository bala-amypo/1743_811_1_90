package com.example.demo.service;

import com.example.demo.model.DuplicateDetection;
import java.util.List;
import java.util.Optional;

public interface DuplicateDetectionService {
    List<DuplicateDetection> getAllLogs();
    Optional<DuplicateDetection> getLogById(Long id);
    DuplicateDetection saveLog(DuplicateDetection log);
    void deleteLog(Long id);
}
