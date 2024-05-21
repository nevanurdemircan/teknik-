package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PartDto {
    private UUID id;
    private String name;
    private Long serviceLife;
}
