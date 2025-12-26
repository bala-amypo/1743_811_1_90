package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;

public interface DuplicateDetectionService {

    DuplicateDetectionLog detectDuplicates(Long ticketId);
}
