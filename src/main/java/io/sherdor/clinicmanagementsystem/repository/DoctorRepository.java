package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByLastNameContainingIgnoreCase(String lastName);
    List<Doctor> findBySpecialtyId(Long specialtyId);

    @Query(value = """
        SELECT d.*
        FROM doctors d
        JOIN app_users au ON au.doctor_id = d.id
        WHERE au.role = 'CHIEF_DOCTOR'
        """, nativeQuery = true)
    Optional<Doctor> findChiefDoctor();
}