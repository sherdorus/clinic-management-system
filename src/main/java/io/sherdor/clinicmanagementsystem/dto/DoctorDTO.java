package io.sherdor.clinicmanagementsystem.dto;

import io.sherdor.clinicmanagementsystem.entity.Doctor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\+?[1-9\\-\\s]{7,15}", message = "Invalid phone number format")
    private String phone;

    private String officeRoom;

    @NotNull(message = "Specialty is required")
    private Long specialtyId;

    private String specialtyName;

    public static DoctorDTO fromEntity(Doctor doctor) {
        return new DoctorDTO(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getOfficeRoom(),
                doctor.getSpecialty() != null ? doctor.getSpecialty().getId() : null,
                doctor.getSpecialty() != null ? doctor.getSpecialty().getName() : null
        );
    }

    public Doctor toEntity() {
        return Doctor.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .officeRoom(officeRoom)
                .build();
    }

    public void updateEntity(Doctor doctor) {
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setEmail(email);
        doctor.setPhone(phone);
        doctor.setOfficeRoom(officeRoom);
    }
}