package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByLastNameContainingIgnoreCase(String lastName);
    List<Patient> findByPrimaryDoctorId(Long doctorId);
    List<Patient> findTop5ByOrderByIdDesc();
}
