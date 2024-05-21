package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class TechnicalServiceCreateDto {

    private UUID customerMachineId;

    private Date date;

    private String process;

    private String description;

    private List<ProcessedPartDto> processedParts;
}
