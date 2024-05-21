package com.info.teknik.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCreateDto {
    private String name;
    private String address;
    private String phone;
    private String email;
}
