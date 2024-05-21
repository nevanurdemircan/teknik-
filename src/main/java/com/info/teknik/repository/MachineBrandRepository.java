package com.info.teknik.repository;

import com.info.teknik.entity.MachineBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MachineBrandRepository extends JpaRepository<MachineBrand, UUID> {
}
