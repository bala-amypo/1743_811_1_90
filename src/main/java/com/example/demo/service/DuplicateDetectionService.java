package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;

public interface DuplicateDetectionService {

    List<DuplicateDetectionLog> detectDuplicates(Long ticketId);

    // Controller compatibility
    List<DuplicateDetectionLog> detectDuplicate(Long ticketId);

    List<DuplicateDetectionLog> getLogsForTicket(Long ticketId);
}
