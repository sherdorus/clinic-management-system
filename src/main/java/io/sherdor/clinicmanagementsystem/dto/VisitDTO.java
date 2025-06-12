package io.sherdor.clinicmanagementsystem.dto;


import io.sherdor.clinicmanagementsystem.model.Appointment;
import io.sherdor.clinicmanagementsystem.model.Doctor;
import io.sherdor.clinicmanagementsystem.model.Patient;
import io.sherdor.clinicmanagementsystem.model.Visit;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDTO {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long appointmentId;
    private LocalDateTime visitDateTime;
    @NotNull
    private String complaints;
    @NotNull
    private String diagnosis;
    @NotNull
    private String treatment;
    private String recommendations;
    @NotNull
    private LocalDateTime createdAt;

    public static VisitDTO fromEntity(Visit visit) {
        return new VisitDTO(
                visit.getId(),
                visit.getPatient() != null ? visit.getPatient().getId() : null,
                visit.getDoctor() != null ? visit.getDoctor().getId() : null,
                visit.getAppointment() != null ? visit.getAppointment().getId() : null,
                visit.getVisitDateTime(),
                visit.getComplaints(),
                visit.getDiagnosis(),
                visit.getTreatment(),
                visit.getRecommendations(),
                visit.getCreatedAt());
    }

    public Visit toEntity(Patient patient, Doctor doctor, Appointment appointment) {
        return Visit.builder()
                .patient(patient)
                .doctor(doctor)
                .appointment(appointment)
                .visitDateTime(visitDateTime)
                .complaints(complaints)
                .diagnosis(diagnosis)
                .treatment(treatment)
                .recommendations(recommendations)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public void updateEntity(Visit visit, Patient patient, Doctor doctor, Appointment appointment) {
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setAppointment(appointment);
        visit.setVisitDateTime(visitDateTime);
        visit.setComplaints(complaints);
        visit.setDiagnosis(diagnosis);
        visit.setTreatment(treatment);
        visit.setRecommendations(recommendations);
    }
}
