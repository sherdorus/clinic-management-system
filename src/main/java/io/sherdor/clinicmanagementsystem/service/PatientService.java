package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.entity.Patient;
import io.sherdor.clinicmanagementsystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Patient not found with id:" + id));
    }

    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Patient> findByLastName(String lastName) {
        return repository.findByLastNameContainingIgnoreCase(lastName);
    }

    public List<Patient> findByDoctor(Long doctorId) {
        return repository.findByPrimaryDoctorId(doctorId);
    }
}
