package com.info.teknik.converter;

import com.info.teknik.dto.CustomerMachineDto;
import com.info.teknik.dto.ProcessedPartGetDto;
import com.info.teknik.dto.TechnicalServiceCreateDto;
import com.info.teknik.dto.TechnicalServiceGetAllDto;
import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.TechnicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TechnicalServiceConverter {

    private final ProcessedPartConverter processedPartConverter;

    private final CustomerMachineConverter customerMachineConverter;

    public TechnicalService createConverter(TechnicalServiceCreateDto dto) {
        TechnicalService technicalService = new TechnicalService();

        CustomerMachine customerMachine = new CustomerMachine();
        customerMachine.setId(dto.getCustomerMachineId());

        technicalService.setDate(dto.getDate());
        technicalService.setDescription(dto.getDescription());
        technicalService.setProcess(dto.getProcess());

        technicalService.setCustomerMachine(customerMachine);

        return technicalService;
    }

    public TechnicalServiceGetAllDto convertToTechnicalServiceGetAllDto(TechnicalService technicalService) {
        TechnicalServiceGetAllDto dto = new TechnicalServiceGetAllDto();
        CustomerMachineDto customerMachineDto = customerMachineConverter.toCustomerMachineDto(technicalService.getCustomerMachine());

        List<ProcessedPartGetDto> processedPart = technicalService.getProcessedParts().stream().map(processedPartConverter::convertToProcessesPart).toList();

        dto.setCustomerMachine(customerMachineDto);
        dto.setProcessedParts(processedPart);
        dto.setDescription(technicalService.getDescription());
        dto.setDate(technicalService.getDate());
        dto.setProcess(technicalService.getProcess());

        return dto;
    }

}
