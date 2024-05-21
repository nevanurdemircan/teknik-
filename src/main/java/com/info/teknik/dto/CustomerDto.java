package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerDto {
    private UUID id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
