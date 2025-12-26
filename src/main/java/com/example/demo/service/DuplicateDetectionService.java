package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;
import java.util.Optional;

public interface DuplicateDetectionLogService {
    List<DuplicateDetectionLog> getAllLogs();
    Optional<DuplicateDetectionLog> getLogById(Long id);
    DuplicateDetectionLog saveLog(DuplicateDetectionLog log);
    void deleteLog(Long id);
}
