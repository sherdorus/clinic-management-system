package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
