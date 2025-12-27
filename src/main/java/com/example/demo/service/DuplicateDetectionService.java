package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;

public interface DuplicateDetectionService {

    // Used by tests + internal logic
    List<DuplicateDetectionLog> detectDuplicates(Long ticketId);

    // Used by controller (alias)
    List<DuplicateDetectionLog> detectDuplicate(Long ticketId);

    List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);
}
