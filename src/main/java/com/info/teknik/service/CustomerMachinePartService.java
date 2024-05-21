package com.info.teknik.service;

import com.info.teknik.converter.CustomerMachinePartConverter;
import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.CustomerMachinePart;
import com.info.teknik.entity.Part;
import com.info.teknik.repository.CustomerMachinePartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerMachinePartService {

    private final CustomerMachinePartRepository customerMachinePartRepository;
    private final CustomerMachinePartConverter converter;

    public List<CustomerMachinePart> customerMachinePartCreator(CustomerMachine customerMachine, List<Part> parts){
        List<CustomerMachinePart> customerMachineParts = converter.createConverter(customerMachine, parts);
        return customerMachinePartRepository.saveAll(customerMachineParts);
    }
}
