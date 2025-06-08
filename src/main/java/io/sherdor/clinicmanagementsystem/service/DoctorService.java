package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.model.Doctor;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;

    public List<Doctor> findAll() {
        return repository.findAll();
    }

    public Doctor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Doctor not found with id:" + id));
    }

    public Doctor save(Doctor doctor) {
        return repository.save(doctor);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Doctor> findByLastName(String lastName) {
        return repository.findByLastNameContainingIgnoreCase(lastName);
    }

    public List<Doctor> findBySpecialty(Long specialtyId) {
        return repository.findBySpecialtyId(specialtyId);
    }
}