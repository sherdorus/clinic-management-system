package io.sherdor.clinicmanagementsystem.dto;

import io.sherdor.clinicmanagementsystem.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 254)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 72, message = "Password must contain between 8 and 72 characters")
    private String password;

    @NotNull(message = "Role is required")
    private Role role;

    private Long patientId;

    private Long doctorId;

}
