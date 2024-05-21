package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class MachineDto {

    private UUID id;

    private String model;

    private String brandName;

    private List<PartDto> parts;
}
