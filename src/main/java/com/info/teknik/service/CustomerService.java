package com.info.teknik.service;

import com.info.teknik.converter.CustomerConverter;
import com.info.teknik.dto.CustomerCreateDto;
import com.info.teknik.dto.CustomerDto;
import com.info.teknik.entity.Customer;
import com.info.teknik.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerConverter converter;

    public ResponseEntity<Void> create (CustomerCreateDto customerDto){
        Customer customer = converter.customerCreateDtoConvertToCustomer(customerDto);
        customerRepository.save(customer);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<CustomerDto>> getAll (){
        List<CustomerDto> customerDtos = customerRepository.findAll().stream().map(converter::convertToCustomerDto).toList();
        return ResponseEntity.ok(customerDtos);
    }
}
