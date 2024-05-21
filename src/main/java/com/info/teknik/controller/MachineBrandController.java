package com.info.teknik.controller;

import com.info.teknik.dto.MachineBrandDto;
import com.info.teknik.service.MachineBrandService;
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
@RequestMapping("api/machine-brand")
@RequiredArgsConstructor
public class MachineBrandController {
    private final MachineBrandService machineBrandService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MachineBrandDto machineBrandDto) {
        return machineBrandService.create(machineBrandDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return machineBrandService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<MachineBrandDto>> getAll() {
        return machineBrandService.getAll();
    }
}
