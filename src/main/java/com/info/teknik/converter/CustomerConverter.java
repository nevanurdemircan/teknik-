package com.info.teknik.converter;

import com.info.teknik.dto.CustomerCreateDto;
import com.info.teknik.dto.CustomerDto;
import com.info.teknik.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    public Customer customerCreateDtoConvertToCustomer(CustomerCreateDto dto){
        Customer customer = new Customer();
        customer.setAddress(dto.getAddress());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        return customer;
    }

    public CustomerDto convertToCustomerDto(Customer entity){
        CustomerDto dto = new CustomerDto();
        dto.setId(entity.getId());
        dto.setAddress(entity.getAddress());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());

        return dto;
    }
}
