package com.info.teknik.controller;

import com.info.teknik.dto.CustomerCreateDto;
import com.info.teknik.dto.CustomerDto;
import com.info.teknik.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CustomerCreateDto customerCreateDto) {
        return customerService.create(customerCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return customerService.getAll();
    }

}
