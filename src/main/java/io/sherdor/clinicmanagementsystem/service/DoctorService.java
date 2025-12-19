package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.DoctorDTO;
import io.sherdor.clinicmanagementsystem.entity.Doctor;
import io.sherdor.clinicmanagementsystem.entity.Specialty;
import io.sherdor.clinicmanagementsystem.exception.ResourceNotFoundException;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
import io.sherdor.clinicmanagementsystem.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final SpecialtyRepository specialtyRepository;

    public List<DoctorDTO> findAll() {

        return doctorRepository.findAll()
                .stream()
                .map(DoctorDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public DoctorDTO findById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + id));
        return DoctorDTO.fromEntity(doctor);
    }

    public DoctorDTO create(DoctorDTO doctorDTO) {
        Specialty specialty = specialtyRepository.findById(doctorDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with id: " + doctorDTO.getId()
                ));
        Doctor doctor = doctorDTO.toEntity();
        doctor.setSpecialty(specialty);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return DoctorDTO.fromEntity(savedDoctor);
    }

    public void deleteById(Long id) {

        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}