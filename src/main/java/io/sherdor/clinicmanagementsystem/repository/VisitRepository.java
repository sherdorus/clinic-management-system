package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findByPatientId(Long patientId);
    List<Visit> findByDoctorId(Long doctorId);
    List<Visit> findByVisitDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
