package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerMachinePartDto {

    private PartDto part;
    private Long nextServiceLife;
}
