package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class TechnicalServiceGetAllDto {
    private CustomerMachineDto customerMachine;

    private Date date;

    private String process;

    private String description;

    private List<ProcessedPartGetDto> processedParts;
}
