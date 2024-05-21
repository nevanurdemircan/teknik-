package com.info.teknik.repository;

import com.info.teknik.entity.TechnicalService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechnicalServiceRepository extends JpaRepository<TechnicalService, UUID> {
}
