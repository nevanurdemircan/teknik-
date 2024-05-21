package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ProcessedPartGetDto {
    private PartDto part;

    private Long currentCount;

    private String process;

    private String description;
}
