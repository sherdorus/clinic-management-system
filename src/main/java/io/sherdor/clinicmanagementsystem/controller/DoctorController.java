package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.DoctorDTO;
import io.sherdor.clinicmanagementsystem.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        var created = doctorService.create(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(created);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByLastName(@RequestParam String lastName){
        return ResponseEntity.ok(doctorService.findByLastName(lastName));
    }

    @GetMapping("/specialty/{specialtyId}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsBySpecialty (@PathVariable Long specialtyId){
        return ResponseEntity.ok(doctorService.findBySpecialtyId(specialtyId));
    }
}