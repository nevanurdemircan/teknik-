package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntity {
    private String name;

    private String lastName;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String mail;

    private String password;

    @Column(unique = true)
    private String phone;
}
