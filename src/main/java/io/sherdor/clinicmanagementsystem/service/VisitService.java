package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.model.Visit;
import io.sherdor.clinicmanagementsystem.repository.VisitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository repository;

    public List<Visit> findAll() {
        return repository.findAll();
    }

    public Visit findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit not found with id:" + id));
    }

    public Visit save(Visit visit) {
        return repository.save(visit);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
