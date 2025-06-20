package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.AppointmentDTO;
import io.sherdor.clinicmanagementsystem.entity.Appointment;
import io.sherdor.clinicmanagementsystem.repository.AppointmentRepository;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
import io.sherdor.clinicmanagementsystem.repository.PatientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentRepository repository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<Appointment> appointments = repository.findAll();
        List<AppointmentDTO> appointmentDTOS = appointments
                .stream()
                .map(AppointmentDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(appointmentDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = repository.findById(id).orElseThrow();
        return ResponseEntity.ok(AppointmentDTO.fromEntity(appointment));
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        var patient = patientRepository.findById(appointmentDTO.getPatientId()).orElseThrow();
        var doctor = doctorRepository.findById(appointmentDTO.getDoctorId()).orElseThrow();
        Appointment appointment = appointmentDTO.toEntity(patient, doctor);
        Appointment savedAppointment = repository.save(appointment);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AppointmentDTO.fromEntity(savedAppointment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id, @Valid @RequestBody AppointmentDTO appointmentDTO) {
        var patient = patientRepository.findById(appointmentDTO.getPatientId()).orElseThrow();
        var doctor = doctorRepository.findById(appointmentDTO.getDoctorId()).orElseThrow();
        Appointment existingAppointment = repository.findById(id).orElseThrow();
        appointmentDTO.updateEntity(existingAppointment, patient, doctor);
        Appointment updatedDoctor = repository.save(existingAppointment);
        return ResponseEntity.ok(AppointmentDTO.fromEntity(updatedDoctor));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}