package com.info.teknik.converter;

import com.info.teknik.dto.ProcessedPartDto;
import com.info.teknik.dto.ProcessedPartGetDto;
import com.info.teknik.entity.Part;
import com.info.teknik.entity.ProcessedPart;
import com.info.teknik.entity.TechnicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProcessedPartConverter {

    private final PartConverter partConverter;

    public ProcessedPart convertToProcessesPart(ProcessedPartDto dto, TechnicalService technicalService){
        ProcessedPart processedPart = new ProcessedPart();

        Part part = new Part();
        part.setId(dto.getPartId());

        processedPart.setProcess(dto.getProcess());
        processedPart.setDescription(dto.getDescription());
        processedPart.setPart(part);
        processedPart.setCurrentCount(dto.getCurrentCount());
        processedPart.setTechnicalService(technicalService);

        return processedPart;
    }

    public ProcessedPartGetDto convertToProcessesPart(ProcessedPart processedPart){
        ProcessedPartGetDto dto = new ProcessedPartGetDto();
        dto.setCurrentCount(processedPart.getCurrentCount());
        dto.setDescription(processedPart.getDescription());
        dto.setProcess(processedPart.getProcess());
        dto.setPart(partConverter.partConvertPartDto(processedPart.getPart()));

        return dto;
    }
}
