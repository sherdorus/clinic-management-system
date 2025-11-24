package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.VisitDTO;
import io.sherdor.clinicmanagementsystem.entity.Visit;
import io.sherdor.clinicmanagementsystem.service.AppointmentService;
import io.sherdor.clinicmanagementsystem.service.DoctorService;
import io.sherdor.clinicmanagementsystem.service.PatientService;
import io.sherdor.clinicmanagementsystem.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<VisitDTO>> getAllVisitors() {
        List<Visit> visits = visitService.findAll();
        List<VisitDTO> visitDTOS = visits.stream()
                .map(VisitDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(visitDTOS);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<VisitDTO> findById(@PathVariable Long id) {
        var visit = visitService.findById(id);
        return ResponseEntity.ok(VisitDTO.fromEntity(visit));
    }

}
