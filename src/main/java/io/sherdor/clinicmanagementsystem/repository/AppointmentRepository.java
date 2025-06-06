package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.model.Appointment;
import io.sherdor.clinicmanagementsystem.model.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository <Appointment, Long> {
    List<Appointment> findByStatus(AppointmentStatus status);
    List<Appointment> findByDoctorIdAndStartDateTimeBetween(Long doctorId, LocalDateTime start, LocalDateTime end);
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findTop5ByOrderByStartDateTimeDesc();
    long countByStatus(AppointmentStatus status);
}