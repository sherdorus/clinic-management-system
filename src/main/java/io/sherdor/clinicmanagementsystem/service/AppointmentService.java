package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.model.Appointment;
import io.sherdor.clinicmanagementsystem.model.AppointmentStatus;
import io.sherdor.clinicmanagementsystem.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Appointment not found with id: " + id));
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> findByStatus(AppointmentStatus status) {
        return appointmentRepository.findByStatus(status);
    }

    public List<Appointment> findByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> findByDoctorAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByDoctorIdAndStartDateTimeBetween(doctorId, start, end);
    }

    public Appointment updateStatus(Long id, AppointmentStatus status) {
        var appointment = findById(id);
        appointment.setStatus(status);
        return save(appointment);
    }

    public List<Appointment> getRecentAppointments() {
        return appointmentRepository.findTop5ByOrderByStartDateTimeDesc();
    }

    public long countByStatus(AppointmentStatus status) {
        return appointmentRepository.countByStatus(status);
    }
}