package com.example.demo.controller;

import com.example.demo.model.DuplicateDetection;
import com.example.demo.repository.DuplicateDetectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/duplicate-logs")
public class DuplicateDetectionController {

    @Autowired
    private DuplicateDetectionRepository logRepository;

    @GetMapping
    public List<DuplicateDetection> getAllLogs() {
        return logRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DuplicateDetection> getLogById(@PathVariable Long id) {
        return logRepository.findById(id);
    }

    @PostMapping
    public DuplicateDetection createLog(@RequestBody DuplicateDetection log) {
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
