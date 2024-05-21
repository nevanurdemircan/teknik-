package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class ProcessedPartDto {
    private UUID partId;

    private Long currentCount;

    private String process;

    private String description;
}
