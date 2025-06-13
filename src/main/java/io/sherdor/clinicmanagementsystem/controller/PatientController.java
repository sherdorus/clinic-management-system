package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.PatientDTO;
import io.sherdor.clinicmanagementsystem.model.Patient;
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
        List<Patient> patients = patientService.findAll();
        List<PatientDTO> patientDTOs = patients.stream()
                .map(PatientDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(patientDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.findById(id);
        return ResponseEntity.ok(PatientDTO.fromEntity(patient));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        var doctor = doctorService.findById(patientDTO.getPrimaryDoctorId());
        Patient patient = patientDTO.toEntity(doctor);
        Patient savedPatient = patientService.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PatientDTO.fromEntity(savedPatient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id,
                                                    @Valid @RequestBody PatientDTO patientDTO) {
        Patient existingPatient = patientService.findById(id);
        var doctor = doctorService.findById(patientDTO.getPrimaryDoctorId());
        patientDTO.updateEntity(existingPatient, doctor);
        Patient updatedPatient = patientService.save(existingPatient);
        return ResponseEntity.ok(PatientDTO.fromEntity(updatedPatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<PatientDTO>> searchPatientsByLastName(@RequestParam String lastName) {
        List<Patient> patients = patientService.findByLastName(lastName);
        List<PatientDTO> patientDTOs = patients.stream()
                .map(PatientDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(patientDTOs);
    }

    @GetMapping("/by-doctor/{doctorId}")
    public ResponseEntity<List<PatientDTO>> getPatientsByDoctor(@PathVariable Long doctorId) {
        List<Patient> patients = patientService.findByDoctor(doctorId);
        List<PatientDTO> patientDTOs = patients.stream()
                .map(PatientDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(patientDTOs);
    }
}