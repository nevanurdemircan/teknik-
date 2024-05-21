package com.info.teknik.controller;

import com.info.teknik.dto.MachineCreateDto;
import com.info.teknik.dto.MachineDto;
import com.info.teknik.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/machine")
@RequiredArgsConstructor
public class MachineController {
    private final MachineService machineService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MachineCreateDto machineCreateDto) {
        return machineService.create(machineCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<MachineDto>> getAll() {
        return machineService.getAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return machineService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<MachineDto> findById(@PathVariable UUID id) {
        return machineService.findById(id);
    }
}
