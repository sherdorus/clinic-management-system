package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
