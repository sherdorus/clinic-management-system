package io.sherdor.clinicmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private LocalDateTime recordDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Record type must be specified")
    private RecordType recordType;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;
}
