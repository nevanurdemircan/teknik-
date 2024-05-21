package com.info.teknik.controller;

import com.info.teknik.dto.CustomerAddMachinePartDto;
import com.info.teknik.dto.CustomerMachineDto;
import com.info.teknik.dto.CustomerMachineGetAllDto;
import com.info.teknik.service.CustomerMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customer-machine")
@RequiredArgsConstructor
public class CustomerMachineController {
    private final CustomerMachineService customerMachinePartService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CustomerAddMachinePartDto customerAddMachinePartDto) {
        return customerMachinePartService.create(customerAddMachinePartDto);
    }

    @PutMapping("{id}/counter/{counter}")
    public ResponseEntity<Void> updateCounter(@PathVariable UUID id,@PathVariable Long counter) {
        return customerMachinePartService.updateCounter(id, counter);
    }

    @GetMapping("customer/{customerId}")
    public ResponseEntity<List<CustomerMachineGetAllDto>> getAllByCustomerId(@PathVariable UUID customerId) {
        return customerMachinePartService.getAllByCustomerId(customerId);
    }

    @GetMapping("{id}/detail")
    public ResponseEntity<CustomerMachineDto> getDetail(@PathVariable UUID id) {
        return customerMachinePartService.getDetail(id);
    }
}
