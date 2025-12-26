package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duplicate-detection")
public class DuplicateDetectionController {

    private final DuplicateDetectionService service;

    public DuplicateDetectionController(DuplicateDetectionService service) {
        this.service = service;
    }

    @PostMapping("/detect/{ticketId}")
    public DuplicateDetectionLog detectDuplicate(@PathVariable Long ticketId) {
        return service.detectDuplicate(ticketId);
    }

    @GetMapping("/logs")
    public List<DuplicateDetectionLog> getAllLogs() {
        return service.getAllLogs();
    }
}
