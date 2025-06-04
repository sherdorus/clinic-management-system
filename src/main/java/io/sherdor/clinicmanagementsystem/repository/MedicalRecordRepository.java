package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
