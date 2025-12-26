package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.PatientDTO;
import io.sherdor.clinicmanagementsystem.exception.ResourceNotFoundException;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
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
public class PatientService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public List<PatientDTO> findAll() {

        return patientRepository.findAll()
                .stream()
                .map(PatientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public PatientDTO findById(Long id) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient not found with id:" + id));
        return PatientDTO.fromEntity(patient);
    }

    public PatientDTO create(PatientDTO patientDTO) {

        var doctor = doctorRepository.findById(patientDTO.getPrimaryDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + patientDTO.getPrimaryDoctorId()));

        var patient = patientDTO.toEntity(doctor);
        var savedPatient = patientRepository.save(patient);
        return PatientDTO.fromEntity(savedPatient);
    }

    public PatientDTO update(Long id, PatientDTO patientDTO) {
        var existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        var doctor = doctorRepository.findById(patientDTO.getPrimaryDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + patientDTO.getPrimaryDoctorId()));
        patientDTO.updateEntity(existingPatient, doctor);
        var updatedPatient = patientRepository.save(existingPatient);
        return PatientDTO.fromEntity(updatedPatient);
    }

    public void deleteById(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }

    public List<PatientDTO> findByLastName(String lastName) {
        return patientRepository.findByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(PatientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<PatientDTO> findByDoctor(Long doctorId) {
        return patientRepository.findByPrimaryDoctorId(doctorId)
                .stream()
                .map(PatientDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
