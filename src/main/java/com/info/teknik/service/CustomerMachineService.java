package com.info.teknik.service;

import com.info.teknik.converter.CustomerMachineConverter;
import com.info.teknik.dto.CustomerAddMachinePartDto;
import com.info.teknik.dto.CustomerMachineDto;
import com.info.teknik.dto.CustomerMachineGetAllDto;
import com.info.teknik.entity.Customer;
import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.Machine;
import com.info.teknik.entity.Part;
import com.info.teknik.repository.CustomerMachineRepository;
import com.info.teknik.repository.CustomerRepository;
import com.info.teknik.repository.MachineRepository;
import com.info.teknik.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerMachineService {

    private final CustomerRepository customerRepository;

    private final MachineRepository machineRepository;

    private final PartRepository partRepository;

    private final CustomerMachineRepository customerMachineRepository;

    private final CustomerMachineConverter converter;

    private final CustomerMachinePartService customerMachinePartService;

    public ResponseEntity<Void> create(CustomerAddMachinePartDto customerAddMachinePartDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerAddMachinePartDto.getCustomerId());
        Optional<Machine> optionalMachine = machineRepository.findById(customerAddMachinePartDto.getMachineId());

        if (optionalCustomer.isEmpty() || optionalMachine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = optionalCustomer.get();
        Machine machine = optionalMachine.get();

        CustomerMachine customerMachinePart = new CustomerMachine();
        customerMachinePart.setCustomer(customer);
        customerMachinePart.setMachine(machine);
        customerMachinePart.setCounter(customerAddMachinePartDto.getCounter());

        customerMachineRepository.save(customerMachinePart);

        List<Part> parts = partRepository.findAllById(customerAddMachinePartDto.getPartIds());
        customerMachinePartService.customerMachinePartCreator(customerMachinePart, parts);

        return ResponseEntity.ok().build();
    }


    public ResponseEntity<Void> updateCounter(UUID id, Long counter) {
        Optional<CustomerMachine> optionalCustomerMachinePart = customerMachineRepository.findById(id);

        if (optionalCustomerMachinePart.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CustomerMachine machinePart = optionalCustomerMachinePart.get();

        machinePart.setCounter(counter);

        customerMachineRepository.save(machinePart);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<CustomerMachineGetAllDto>> getAllByCustomerId(UUID customerId) {
        List<CustomerMachine> customerMachineParts = customerMachineRepository.findAllByCustomerId(customerId);
        List<CustomerMachineGetAllDto> response = customerMachineParts.stream().map(converter::toCustomerMachineGetAllDto).toList();
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<CustomerMachineDto> getDetail(UUID id) {
        Optional<CustomerMachine> optionalCustomerMachine = customerMachineRepository.findById(id);
        return optionalCustomerMachine.map(customerMachine -> ResponseEntity.ok(converter.toCustomerMachineDto(customerMachine))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
