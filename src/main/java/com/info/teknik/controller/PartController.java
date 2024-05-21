package com.info.teknik.controller;

import com.info.teknik.dto.PartDto;
import com.info.teknik.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/part")
@RequiredArgsConstructor
public class PartController {
    private final PartService partService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PartDto partDto){
        return partService.create(partDto);
    }
}
