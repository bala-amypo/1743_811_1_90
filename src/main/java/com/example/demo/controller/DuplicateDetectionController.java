package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duplicate-detection")
@RequiredArgsConstructor
public class DuplicateDetectionController {

    private final DuplicateDetectionService detectionService;

    @PostMapping("/detect/{ticketId}")
    public ResponseEntity<DuplicateDetectionLog> detect(@PathVariable Long ticketId) {
        return ResponseEntity.ok(detectionService.detectDuplicate(ticketId));
    }

    @GetMapping("/logs/{ticketId}")
    public ResponseEntity<List<DuplicateDetectionLog>> getLogs(@PathVariable Long ticketId) {
        return ResponseEntity.ok(detectionService.getLogsForTicket(ticketId));
    }
}
