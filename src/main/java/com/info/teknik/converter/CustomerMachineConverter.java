package com.info.teknik.converter;

import com.info.teknik.dto.CustomerDto;
import com.info.teknik.dto.CustomerMachineDto;
import com.info.teknik.dto.CustomerMachineGetAllDto;
import com.info.teknik.dto.CustomerMachinePartDto;
import com.info.teknik.dto.MachineDto;
import com.info.teknik.dto.PartDto;
import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.CustomerMachinePart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerMachineConverter {

    private final CustomerConverter customerConverter;
    private final MachineConverter machineConverter;
    private final CustomerMachinePartConverter customerMachinePartConverter;

    private final PartConverter partConverter;

    public CustomerMachineGetAllDto toCustomerMachineGetAllDto(CustomerMachine entity) {
        CustomerMachineGetAllDto dto = new CustomerMachineGetAllDto();
        dto.setId(entity.getId());
        dto.setCustomerName(entity.getCustomer().getName());
        dto.setMachineModel(entity.getMachine().getModel());

        return dto;
    }

    public CustomerMachineDto toCustomerMachineDto(CustomerMachine entity) {
        CustomerMachineDto dto = new CustomerMachineDto();

        List<CustomerMachinePartDto> customerMachinePartDtoList = entity.getCustomerMachineParts().stream().map(this::customerMachinePartconvertToCustomerMachinePartDto).toList();
        MachineDto machineDto = machineConverter.machineConvertToMachineDto(entity.getMachine());
        CustomerDto customerDto = customerConverter.convertToCustomerDto(entity.getCustomer());

        dto.setId(entity.getId());
        dto.setMachine(machineDto);
        dto.setCustomer(customerDto);
        dto.setCounter(entity.getCounter());
        dto.setParts(customerMachinePartDtoList);

        return dto;
    }

    public CustomerMachinePartDto customerMachinePartconvertToCustomerMachinePartDto(CustomerMachinePart customerMachinePart){
        CustomerMachinePartDto dto = new CustomerMachinePartDto();

        PartDto partDto = partConverter.partConvertPartDto(customerMachinePart.getPart());
        dto.setPart(partDto);
        dto.setNextServiceLife(customerMachinePart.getNextServiceLife());
        return dto;
    }
}
