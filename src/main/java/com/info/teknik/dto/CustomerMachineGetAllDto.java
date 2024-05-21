package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerMachineGetAllDto {

    private UUID id;

    private String customerName;

    private String machineModel;
}
