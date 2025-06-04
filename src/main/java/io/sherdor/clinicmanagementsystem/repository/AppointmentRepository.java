package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository <Appointment, Long> {
}
