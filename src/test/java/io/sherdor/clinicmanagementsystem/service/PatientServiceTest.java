package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.PatientDTO;
import io.sherdor.clinicmanagementsystem.entity.Doctor;
import io.sherdor.clinicmanagementsystem.entity.Patient;
import io.sherdor.clinicmanagementsystem.enums.Gender;
import io.sherdor.clinicmanagementsystem.exception.ResourceNotFoundException;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
import io.sherdor.clinicmanagementsystem.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import java.time.LocalDate;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @Mock
    private PatientRepository patientRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private PatientService patientService;

    private Doctor doctor;
    private PatientDTO patientDTO;

    @BeforeEach
    void setUp(){
        doctor = Doctor.builder()
                .id(1L)
                .firstName("John")
                .lastName("Smith")
                .build();

        patientDTO = new PatientDTO(
                null,
                "Jane",
                "Doe",
                LocalDate.of(1990,5,15),
                Gender.FEMALE,
                "+1234567890",
                "jane@example.com",
                "123 Main Street",
                1L);
    }

    @Test
    void create_shouldCreatePatient_whenDoctorExists(){
        when(doctorRepository.findById(1L)).thenReturn(Optional.of(doctor));

        Patient savedPatient = patientDTO.toEntity(doctor);
        savedPatient.setId(10L);

        when(patientRepository.save(any(Patient.class))).thenReturn(savedPatient);

        PatientDTO result = patientService.create(patientDTO);
        assertNotNull(result);
        assertEquals(10L, result.getId());
        assertEquals("Jane", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals(1L, result.getPrimaryDoctorId());

        verify(doctorRepository).findById(1L);
        verify(patientRepository).save(any(Patient.class));
    }

    @Test
    void create_shouldThrowException_whenDoctorDoesNotExist() {
        when(doctorRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> patientService.create(patientDTO)
        );

        verify(patientRepository, never()).save(any(Patient.class));
    }

}
