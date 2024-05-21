package com.info.teknik.repository;

import com.info.teknik.entity.ProcessedPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProcessedPartRepository extends JpaRepository<ProcessedPart, UUID> {
}
