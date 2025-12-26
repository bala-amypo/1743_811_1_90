package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {

    private final DuplicateDetectionService detectionService;

    public DuplicateDetectionController(DuplicateDetectionService detectionService) {
        this.detectionService = detectionService;
    }

    @GetMapping("/run/{ticketId}")
    public List<DuplicateDetectionLog> run(@PathVariable Long ticketId) {
        return detectionService.detectDuplicates(ticketId);
    }

    @GetMapping("/ticket/{ticketId}")
    public List<DuplicateDetectionLog> logsForTicket(@PathVariable Long ticketId) {
        return detectionService.getLogsForTicket(ticketId);
    }

    @GetMapping("/{id}")
    public DuplicateDetectionLog get(@PathVariable Long id) {
        return detectionService.getLog(id);
    }
}