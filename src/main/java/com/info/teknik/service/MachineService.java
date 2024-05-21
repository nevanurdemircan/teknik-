package com.info.teknik.service;

import com.info.teknik.converter.MachineConverter;
import com.info.teknik.converter.PartConverter;
import com.info.teknik.dto.MachineCreateDto;
import com.info.teknik.dto.MachineDto;
import com.info.teknik.entity.Machine;
import com.info.teknik.entity.MachineBrand;
import com.info.teknik.entity.Part;
import com.info.teknik.repository.MachineRepository;
import com.info.teknik.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MachineService {
    private final MachineRepository machineRepository;

    private final MachineConverter machineConverter;

    private final PartRepository partRepository;

    private final PartConverter partConverter;

    public ResponseEntity<Void> create(MachineCreateDto machineCreateDto) {
        Machine machine = new Machine();

        MachineBrand brand = new MachineBrand();

        brand.setId(machineCreateDto.getBrandId());
        machine.setModel(machineCreateDto.getModel());
        machine.setBrand(brand);

        Machine savedMachine = machineRepository.save(machine);

        List<Part> parts = machineCreateDto.getParts().stream().map(partDto -> partConverter.partDtoConvertMachine(savedMachine, partDto)).toList();
        partRepository.saveAll(parts);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<MachineDto>> getAll() {
        List<Machine> result = machineRepository.findAll();

        List<MachineDto> machines = result.stream().map(machineConverter::machineConvertToMachineDto).toList();

        return ResponseEntity.ok(machines);
    }


    public ResponseEntity<Void> delete(UUID id) {
        machineRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<MachineDto> findById(UUID id) {
        Optional<Machine> optionalMachine = machineRepository.findById(id);

        if (optionalMachine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        MachineDto machine = machineConverter.machineConvertToMachineDto(optionalMachine.get());

        return ResponseEntity.ok(machine);
    }


}
