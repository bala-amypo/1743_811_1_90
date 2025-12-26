package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/duplicate-logs")
public class DuplicateDetectionLogController {

    @Autowired
    private DuplicateDetectionLogRepository logRepository;

    @GetMapping
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DuplicateDetectionLog> getLogById(@PathVariable Long id) {
        return logRepository.findById(id);
    }

    @PostMapping
    public DuplicateDetectionLog createLog(@RequestBody DuplicateDetectionLog log) {
        return logRepository.save(log);
    }

    @PutMapping("/{id}")
    public DuplicateDetectionLog updateLog(@PathVariable Long id, @RequestBody DuplicateDetectionLog log) {
        log.setId(id);
        return logRepository.save(log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        logRepository.deleteById(id);
    }
}
