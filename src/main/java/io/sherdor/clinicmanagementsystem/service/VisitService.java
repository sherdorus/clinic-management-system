package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.VisitDTO;
import io.sherdor.clinicmanagementsystem.exception.ResourceNotFoundException;
import io.sherdor.clinicmanagementsystem.repository.AppointmentRepository;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
import io.sherdor.clinicmanagementsystem.repository.PatientRepository;
import io.sherdor.clinicmanagementsystem.repository.VisitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public List<VisitDTO> findAll() {
        return visitRepository.findAll()
                .stream()
                .map(VisitDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public VisitDTO findById(Long id) {
        var visit = visitRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit not found with id:" + id));
        return VisitDTO.fromEntity(visit);
    }

    public VisitDTO create(VisitDTO visitDTO) {
        var doctor = doctorRepository.findById(visitDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id:" + visitDTO.getDoctorId()));
        var patient = patientRepository.findById(visitDTO.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id:" + visitDTO.getPatientId()));
        var appointment = appointmentRepository.findById(visitDTO.getAppointmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id:" + visitDTO.getPatientId()));
        var visit = visitDTO.toEntity(patient, doctor, appointment);
        var savedVisit = visitRepository.save(visit);
        return VisitDTO.fromEntity(savedVisit);
    }

    public void deleteById(Long id) {
        if (!visitRepository.existsById(id)) {
            throw new ResourceNotFoundException("Visit not found with id: " + id);
        }
        visitRepository.deleteById(id);
    }
}
