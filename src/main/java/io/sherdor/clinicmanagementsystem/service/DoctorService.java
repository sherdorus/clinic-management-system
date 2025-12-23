package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.DoctorDTO;
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
        var doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + id));
        return DoctorDTO.fromEntity(doctor);
    }

    public DoctorDTO create(DoctorDTO doctorDTO) {
        var specialty = specialtyRepository.findById(doctorDTO.getSpecialtyId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Specialty not found with id: " + doctorDTO.getId()
                ));
        var doctor = doctorDTO.toEntity();
        doctor.setSpecialty(specialty);
        var savedDoctor = doctorRepository.save(doctor);
        return DoctorDTO.fromEntity(savedDoctor);
    }

    public void deleteById(Long id) {

        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}