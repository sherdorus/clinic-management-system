package io.sherdor.clinicmanagementsystem.dto;

import io.sherdor.clinicmanagementsystem.model.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    @NotNull
    private Long patientId;
    @NotNull
    private Long doctorId;
    @NotNull
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String reason;
    private AppointmentStatus status;
    private String notes;


    public static AppointmentDTO fromEntity(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getId(),
                appointment.getPatient() != null ? appointment.getPatient().getId() : null,
                appointment.getDoctor()!= null ? appointment.getDoctor().getId() : null,
                appointment.getStartDateTime(),
                appointment.getEndDateTime(),
                appointment.getReason(),
                appointment.getStatus(),
                appointment.getNotes()
        );
    }

    public Appointment toEntity(Patient patient, Doctor doctor) {
        return Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .reason(reason)
                .status(status)
                .notes(notes)
                .build();
    }

    public void updateEntity(Appointment appointment,Patient patient, Doctor doctor){
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStartDateTime(startDateTime);
        appointment.setEndDateTime(endDateTime);
        appointment.setReason(reason);
        appointment.setStatus(status);
        appointment.setNotes(notes);

    }
}