package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.entity.MedicalRecord;
import io.sherdor.clinicmanagementsystem.repository.MedicalRecordRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository repository;

    public List<MedicalRecord> findAll() {
        return repository.findAll();
    }

    public MedicalRecord findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("MedicalRecord not found with id:" + id));
    }

    public MedicalRecord save(MedicalRecord medicalRecord) {
        return repository.save(medicalRecord);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
