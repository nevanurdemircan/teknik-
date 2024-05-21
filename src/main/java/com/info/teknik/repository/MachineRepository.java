package com.info.teknik.repository;

import com.info.teknik.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MachineRepository extends JpaRepository<Machine, UUID> {
}
