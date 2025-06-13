package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.MedicalRecordDTO;
import io.sherdor.clinicmanagementsystem.model.MedicalRecord;
import io.sherdor.clinicmanagementsystem.service.DoctorService;
import io.sherdor.clinicmanagementsystem.service.MedicalRecordService;
import io.sherdor.clinicmanagementsystem.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class MedicalRecordController {
    private final MedicalRecordService medicalRecordService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<MedicalRecordDTO>> getAllRecords() {
        List<MedicalRecord> medicalRecordList = medicalRecordService.findAll();
        List<MedicalRecordDTO> medicalRecordDTOList = medicalRecordList.stream()
                .map(MedicalRecordDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(medicalRecordDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecordDTO> getRecordsById(@PathVariable Long id) {
        MedicalRecord record = medicalRecordService.findById(id);
        return ResponseEntity.ok(MedicalRecordDTO.fromEntity(record));
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDTO> createRecord(@Valid @RequestBody MedicalRecordDTO recordDTO) {
        var patient = patientService.findById(recordDTO.getPatientId());
        var doctor = doctorService.findById(recordDTO.getDoctorId());
        MedicalRecord record = recordDTO.toEntity(patient, doctor);
        MedicalRecord savedRecord = medicalRecordService.save(record);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MedicalRecordDTO.fromEntity(savedRecord));
    }

}