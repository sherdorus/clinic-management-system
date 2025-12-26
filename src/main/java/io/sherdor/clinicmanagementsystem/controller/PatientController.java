package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.PatientDTO;
import io.sherdor.clinicmanagementsystem.entity.Patient;
import io.sherdor.clinicmanagementsystem.service.DoctorService;
import io.sherdor.clinicmanagementsystem.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {

        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        var created = patientService.create(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id,
                                                    @Valid @RequestBody PatientDTO patientDTO) {
        var updated = patientService.update(id, patientDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PatientDTO>> searchPatientsByLastName(@RequestParam String lastName) {
        return ResponseEntity.ok(patientService.findByLastName(lastName));
    }

    @GetMapping("/by-doctor/{doctorId}")
    public ResponseEntity<List<PatientDTO>> getPatientsByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(patientService.findByDoctor(doctorId));
    }
}