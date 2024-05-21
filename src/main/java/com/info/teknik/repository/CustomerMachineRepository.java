package com.info.teknik.repository;

import com.info.teknik.entity.CustomerMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerMachineRepository extends JpaRepository<CustomerMachine, UUID> {

    List<CustomerMachine> findAllByCustomerId(UUID customerId);
}
