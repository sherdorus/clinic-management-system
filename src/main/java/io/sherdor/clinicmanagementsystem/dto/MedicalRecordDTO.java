package io.sherdor.clinicmanagementsystem.dto;

import io.sherdor.clinicmanagementsystem.model.Doctor;
import io.sherdor.clinicmanagementsystem.model.MedicalRecord;
import io.sherdor.clinicmanagementsystem.model.Patient;
import io.sherdor.clinicmanagementsystem.model.RecordType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordDTO {
    private Long id;
    @NotNull
    private Long patientId;
    @NotNull
    private RecordType recordType;
    @NotNull
    private LocalDate recordDate;

    private String content;
    @NotNull
    private Long doctorId;

    private LocalDateTime createdAt;

    public static MedicalRecordDTO fromEntity(MedicalRecord record) {
        return new MedicalRecordDTO(
                record.getId(),
                record.getPatient() != null ? record.getPatient().getId() : null,
                record.getRecordType(),
                record.getRecordDate(),
                record.getContent(),
                record.getDoctor() != null ? record.getDoctor().getId() : null,
                record.getCreatedAt()
        );
    }

    public MedicalRecord toEntity(Patient patient, Doctor doctor) {
        return MedicalRecord.builder()
                .patient(patient)
                .recordType(recordType)
                .recordDate(recordDate)
                .content(content)
                .doctor(doctor)
                .createdAt(createdAt)
                .build();
    }

    public void updateEntity(MedicalRecord record, Patient patient, Doctor doctor) {
        record.setPatient(patient);
        record.setRecordType(recordType);
        record.setRecordDate(recordDate);
        record.setContent(content);
        record.setDoctor(doctor);
        record.setCreatedAt(createdAt);
    }

}
