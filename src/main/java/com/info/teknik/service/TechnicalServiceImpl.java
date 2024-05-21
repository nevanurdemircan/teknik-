package com.info.teknik.service;

import com.info.teknik.converter.ProcessedPartConverter;
import com.info.teknik.converter.TechnicalServiceConverter;
import com.info.teknik.dto.TechnicalServiceCreateDto;
import com.info.teknik.dto.TechnicalServiceGetAllDto;
import com.info.teknik.entity.CustomerMachine;
import com.info.teknik.entity.ProcessedPart;
import com.info.teknik.entity.TechnicalService;
import com.info.teknik.repository.CustomerMachineRepository;
import com.info.teknik.repository.ProcessedPartRepository;
import com.info.teknik.repository.TechnicalServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TechnicalServiceImpl {

    private final TechnicalServiceRepository technicalServiceRepository;

    private final TechnicalServiceConverter converter;

    private final ProcessedPartConverter processedPartConverter;
    private final ProcessedPartRepository processedPartRepository;

    private final CustomerMachineRepository customerMachineRepository;

    public void save(TechnicalServiceCreateDto technicalServiceCreateDto) {

        TechnicalService technicalService = technicalServiceRepository.save(converter.createConverter(technicalServiceCreateDto));

        List<ProcessedPart> processedParts = technicalServiceCreateDto.getProcessedParts().stream().map(processedPart -> processedPartConverter.convertToProcessesPart(processedPart, technicalService)).toList();

        processedPartRepository.saveAll(processedParts);
    }

    public List<TechnicalServiceGetAllDto> getAllTechnicalServiceByCustomerId(UUID customerId) {
        List<TechnicalServiceGetAllDto> result = new ArrayList<>();

        List<CustomerMachine> customerMachines = customerMachineRepository.findAllByCustomerId(customerId);
        customerMachines.forEach(customerMachine -> {
             result.addAll(customerMachine.getTechnicalServices().stream().map(converter::convertToTechnicalServiceGetAllDto).toList());
        });

        return result;
    }
}
