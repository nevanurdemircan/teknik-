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
public class ProcessedPart extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "technical_service_id")
    private TechnicalService technicalService;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;

    private Long currentCount;

    private String process;

    private String description;
}
