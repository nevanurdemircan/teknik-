package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class MachineBrand extends BaseEntity {
    private String name;

    @OneToMany(mappedBy="brand")
    private List<Machine> machines;
}
