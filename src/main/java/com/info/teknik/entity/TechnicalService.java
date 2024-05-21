package com.info.teknik.entity;

import com.info.teknik.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class TechnicalService extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "customer_machine_id")
    private CustomerMachine customerMachine;

    private Date date;

    private String process;

    private String description;

    @OneToMany(mappedBy = "technicalService")
    private List<ProcessedPart> processedParts;
}
