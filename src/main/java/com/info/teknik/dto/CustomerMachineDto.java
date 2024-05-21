package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class CustomerMachineDto {

    private UUID id;

    private MachineDto machine;

    private CustomerDto customer;

    private List<CustomerMachinePartDto> parts;

    private Long counter;
}
