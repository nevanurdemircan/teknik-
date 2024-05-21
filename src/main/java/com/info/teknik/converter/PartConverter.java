package com.info.teknik.converter;

import com.info.teknik.dto.PartDto;
import com.info.teknik.entity.Machine;
import com.info.teknik.entity.Part;
import org.springframework.stereotype.Component;

@Component
public class PartConverter {
    public PartDto partConvertPartDto(Part part) {
        PartDto partDto = new PartDto();
        partDto.setName(part.getName());
        partDto.setId(part.getId());
        partDto.setServiceLife(part.getServiceLife());
        return partDto;
    }

    public Part partDtoConvertMachine(Machine machine, PartDto dto) {
        Part part = new Part();
        part.setMachine(machine);
        part.setName(dto.getName());
        part.setServiceLife(dto.getServiceLife());
        return part;
    }
    public Part partDtoConvertToPart(PartDto partDto){
        Part part = new Part();
        part.setName(partDto.getName());
        part.setServiceLife(partDto.getServiceLife());
        return part;
    }
}
