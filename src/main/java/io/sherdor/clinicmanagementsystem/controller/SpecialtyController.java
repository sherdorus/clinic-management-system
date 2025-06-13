package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.SpecialtyDTO;
import io.sherdor.clinicmanagementsystem.model.Specialty;
import io.sherdor.clinicmanagementsystem.service.SpecialtyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialties")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService specialtyService;


    @GetMapping
    public ResponseEntity<List<SpecialtyDTO>> getAllSpecialties() {
        List<Specialty> specialty = specialtyService.findAll();
        List<SpecialtyDTO> specialtyDTOS = specialty.stream()
                .map(SpecialtyDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(specialtyDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> getSpecialtyById(@PathVariable Long id) {
        var specialty = specialtyService.findById(id);
        return ResponseEntity.ok(SpecialtyDTO.fromEntity(specialty));
    }

    @PostMapping
    public ResponseEntity<SpecialtyDTO> create(@Valid @RequestBody SpecialtyDTO specialtyDTO) {
        var specialty = specialtyDTO.toEntity();
        var createdSpecialty = specialtyService.save(specialty);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SpecialtyDTO.fromEntity(createdSpecialty));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> updateSpecialty(@PathVariable Long id, @Valid @RequestBody SpecialtyDTO specialtyDTO) {
        var existing = specialtyService.findById(id);
        specialtyDTO.updateEntity(existing);
        var updated = specialtyService.save(existing);
        return ResponseEntity.ok(SpecialtyDTO.fromEntity(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialty(@PathVariable Long id) {
        specialtyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}