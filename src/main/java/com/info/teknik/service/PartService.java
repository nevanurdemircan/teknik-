package com.info.teknik.service;

import com.info.teknik.converter.PartConverter;
import com.info.teknik.dto.PartDto;
import com.info.teknik.entity.*;
import com.info.teknik.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartService {
    private final PartRepository partRepository;
    private final PartConverter partConverter;

    public ResponseEntity<Void> create (PartDto partDto){
        Part part= partConverter.partDtoConvertToPart(partDto);
        partRepository.save(part);
        return ResponseEntity.ok().build();
    }
}
