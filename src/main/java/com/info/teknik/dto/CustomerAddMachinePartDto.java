package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomerAddMachinePartDto {

    private UUID customerId;
    private UUID machineId;
    private List<UUID> partIds;
    private Long counter;
}
