package io.sherdor.clinicmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Patient's first name must not be empty")
    private String firstName;

    @NotBlank(message = "Patient's last name must not be empty")
    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\+?[0-9\\-\\s]{7,15}", message = "Invalid phone number")
    private String phone;

    private String dateOfBirth;

    private String gender;

    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "primary_doctor_id")
    private Doctor primaryDoctor;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MedicalRecord> medicalRecords = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Appointment> appointments = new ArrayList<>();

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
