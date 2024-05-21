package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Part extends BaseEntity {
    private String name;

    private Long serviceLife;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;
}
