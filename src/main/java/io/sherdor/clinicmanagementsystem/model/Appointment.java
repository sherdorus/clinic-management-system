package io.sherdor.clinicmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Visit visit;

    @NotNull(message = "Start date/time must be specified")
    LocalDateTime startDateTime;

    @NotNull(message = "End date/time must be specified")
    LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AppointmentStatus appointmentStatus;

    private String reason;
}
