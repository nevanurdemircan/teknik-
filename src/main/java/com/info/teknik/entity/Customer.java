package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Customer extends BaseEntity {
    private String name;
    @Column(unique = true)
    private String address;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;

}
