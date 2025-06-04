package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
