package io.sherdor.clinicmanagementsystem.dto;

import io.sherdor.clinicmanagementsystem.model.Doctor;
import io.sherdor.clinicmanagementsystem.model.Gender;
import io.sherdor.clinicmanagementsystem.model.Patient;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @Pattern(regexp = "\\+?[1-9\\-\\s]{7,15}", message = "Invalid phone number format")
    private String phone;

    @Email(message = "Invalid email format")
    private String email;

    private String address;
    private Long primaryDoctorId;

    public static PatientDTO fromEntity(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getPhone(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getPrimaryDoctor() != null ? patient.getPrimaryDoctor().getId() : null
        );
    }

    public Patient toEntity(Doctor doctor) {
        return Patient.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .phone(phone)
                .email(email)
                .address(address)
                .primaryDoctor(doctor)
                .build();
    }

    public void updateEntity(Patient patient, Doctor doctor){
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDateOfBirth(dateOfBirth);
        patient.setGender(gender);
        patient.setPhone(phone);
        patient.setEmail(email);
        patient.setAddress(address);
        patient.setPrimaryDoctor(doctor);
    }
}
