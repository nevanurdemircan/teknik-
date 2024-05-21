package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class MachineCreateDto {
    private String model;

    private UUID brandId;

    private List<PartDto> parts;
}
