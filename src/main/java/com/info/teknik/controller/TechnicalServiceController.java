package com.info.teknik.controller;

import com.info.teknik.dto.TechnicalServiceCreateDto;
import com.info.teknik.dto.TechnicalServiceGetAllDto;
import com.info.teknik.service.TechnicalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/technical-service")
@RequiredArgsConstructor
public class TechnicalServiceController {
    private final TechnicalServiceImpl technicalService;

    @PostMapping
    public ResponseEntity<Void> create (@RequestBody TechnicalServiceCreateDto technicalServiceCreateDto){
         technicalService.save(technicalServiceCreateDto);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<TechnicalServiceGetAllDto>> getAllTechnicalServiceByCustomerId(@PathVariable UUID customerId){
        return ResponseEntity.ok(technicalService.getAllTechnicalServiceByCustomerId(customerId));
    }
}
