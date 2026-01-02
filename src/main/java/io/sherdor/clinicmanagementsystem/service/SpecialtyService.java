package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.SpecialtyDTO;
import io.sherdor.clinicmanagementsystem.exception.ResourceNotFoundException;
import io.sherdor.clinicmanagementsystem.repository.SpecialtyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public List<SpecialtyDTO> findAll() {

        return specialtyRepository.findAll()
                .stream()
                .map(SpecialtyDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public SpecialtyDTO findById(Long id) {
        var specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Specialty not found with id: " + id));
        return SpecialtyDTO.fromEntity(specialty);
    }

    public SpecialtyDTO create(SpecialtyDTO specialtyDTO) {
        var specialty = specialtyDTO.toEntity();
        var savedSpecialty = specialtyRepository.save(specialty);
        return SpecialtyDTO.fromEntity(savedSpecialty);
    }

    public SpecialtyDTO update(Long id, SpecialtyDTO specialtyDTO) {
        var specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Specialty not found with id: " + id));
        specialtyDTO.updateEntity(specialty);
        var updatedSpecialty = specialtyRepository.save(specialty);
        return SpecialtyDTO.fromEntity(updatedSpecialty);
    }

    public void deleteById(Long id) {
        if (!specialtyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Specialty not found with id: " + id);
        }
        specialtyRepository.deleteById(id);
    }
}
