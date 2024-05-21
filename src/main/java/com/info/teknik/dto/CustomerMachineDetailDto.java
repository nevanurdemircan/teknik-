package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomerMachineDetailDto {

    private UUID id;

    private MachineDto machine;

    private CustomerDto customer;

    private List<CustomerMachinePartDto> parts;

    private Long counter;
}
