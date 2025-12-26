package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import java.util.List;

public interface DuplicateDetectionService {
    void detectDuplicates(long ticketId);
    List<DuplicateDetectionLog> getLogsForTicket(long ticketId);
}
