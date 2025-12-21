package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.MedicalRecordDTO;
import io.sherdor.clinicmanagementsystem.exception.ResourceNotFoundException;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
import io.sherdor.clinicmanagementsystem.repository.MedicalRecordRepository;
import io.sherdor.clinicmanagementsystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public List<MedicalRecordDTO> findAll() {

        return medicalRecordRepository.findAll()
                .stream()
                .map(MedicalRecordDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public MedicalRecordDTO findById(Long id) {
        var record = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Record not found with id:" + id));
        return MedicalRecordDTO.fromEntity(record);
    }

    public MedicalRecordDTO create(MedicalRecordDTO medicalRecordDTO) {
        var patient = patientRepository.findById(medicalRecordDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with id: " + medicalRecordDTO.getPatientId()));
        var doctor = doctorRepository.findById(medicalRecordDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with id: " + medicalRecordDTO.getDoctorId()));

        var medicalRecord = medicalRecordDTO.toEntity(patient, doctor);
        var saved = medicalRecordRepository.save(medicalRecord);
        return MedicalRecordDTO.fromEntity(saved);
    }

    public void deleteById(Long id) {
        if (!medicalRecordRepository.existsById(id)) {
            throw new ResourceNotFoundException("Appointment not found with id: " + id);
        }
        medicalRecordRepository.deleteById(id);
    }
}
