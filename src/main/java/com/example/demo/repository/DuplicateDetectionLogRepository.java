package com.example.demo.repository;

import com.example.demo.model.DuplicateDetectionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuplicateDetectionLogRepository extends JpaRepository<DuplicateDetectionLog, Long> {
}
