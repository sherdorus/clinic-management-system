package io.sherdor.clinicmanagementsystem.dto;


import io.sherdor.clinicmanagementsystem.model.Specialty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialtyDTO {

    private Long id;

    @NotBlank(message = "Specialty name is required")
    private String name;

    private String description;

    private static SpecialtyDTO fromEntity(Specialty specialty) {
        return new SpecialtyDTO(
                specialty.getId(),
                specialty.getName(),
                specialty.getDescription()
        );
    }

    private Specialty toEntity() {
        return Specialty.builder()
                .name(name)
                .description(description)
                .build();
    }

    private void updateEntity(Specialty specialty) {
        specialty.setName(name);
        specialty.setDescription(description);
    }
}
