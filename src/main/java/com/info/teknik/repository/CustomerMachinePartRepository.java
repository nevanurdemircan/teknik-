package com.info.teknik.repository;

import com.info.teknik.entity.CustomerMachinePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerMachinePartRepository extends JpaRepository<CustomerMachinePart, UUID> {
}
