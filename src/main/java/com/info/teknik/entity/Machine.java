package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@Entity
@Getter
@Setter
public class Machine extends BaseEntity {

    private String model;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private MachineBrand brand;

    @OneToMany(mappedBy = "machine")
    private List<Part> parts;

    @OneToMany(mappedBy = "machine")
    private List<CustomerMachine> customerMachines;
}
