package com.info.teknik.service;

import com.info.teknik.converter.MachineBrandConverter;
import com.info.teknik.dto.MachineBrandDto;
import com.info.teknik.entity.MachineBrand;
import com.info.teknik.repository.MachineBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MachineBrandService {

    private final MachineBrandRepository machineBrandRepository;
    private final MachineBrandConverter machineBrandConverter;


    public ResponseEntity<Void> create(MachineBrandDto machineBrandDto){
        MachineBrand machineBrand = new MachineBrand();
        machineBrand.setName(machineBrandDto.getName());

        machineBrandRepository.save(machineBrand);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> delete (UUID id){
        machineBrandRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<List<MachineBrandDto>> getAll(){
        List<MachineBrand> machineBrands = machineBrandRepository.findAll();
        List<MachineBrandDto> machineBrandDtos = machineBrands.stream().map(machineBrandConverter::machineBrandDtoConvertToMachineBrand).collect(Collectors.toList());
        return ResponseEntity.ok(machineBrandDtos);
    }
}
