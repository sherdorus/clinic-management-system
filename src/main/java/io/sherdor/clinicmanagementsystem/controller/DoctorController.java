package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.DoctorDTO;
import io.sherdor.clinicmanagementsystem.model.Doctor;
import io.sherdor.clinicmanagementsystem.model.Specialty;
import io.sherdor.clinicmanagementsystem.service.DoctorService;
import io.sherdor.clinicmanagementsystem.service.SpecialtyService;
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
    private final SpecialtyService specialtyService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<Doctor> doctors = doctorService.findAll();
        List<DoctorDTO> doctorDTOS = doctors.stream()
                .map(DoctorDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(doctorDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.findById(id);
        return ResponseEntity.ok(DoctorDTO.fromEntity(doctor));
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        Specialty specialty = specialtyService.findById(doctorDTO.getSpecialtyId());
        Doctor doctor = doctorDTO.toEntity();
        doctor.setSpecialty(specialty);
        Doctor savedDoctor = doctorService.save(doctor);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(DoctorDTO.fromEntity(savedDoctor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorService.findById(id);
        doctorDTO.updateEntity(existingDoctor);
        Doctor updatedDoctor = doctorService.save(existingDoctor);
        return ResponseEntity.ok(DoctorDTO.fromEntity(updatedDoctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}