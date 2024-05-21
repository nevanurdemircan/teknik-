package com.info.teknik.repository;

import com.info.teknik.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartRepository extends JpaRepository<Part, UUID> {
}
