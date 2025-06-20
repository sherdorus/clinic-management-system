package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.entity.Specialty;
import io.sherdor.clinicmanagementsystem.repository.SpecialtyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class SpecialtyService {

    private final SpecialtyRepository repository;

    public List<Specialty> findAll() {
        return repository.findAll();
    }

    public Specialty findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Specialty not found with id:" + id));
    }

    public Specialty save(Specialty specialty) {
        return repository.save(specialty);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
