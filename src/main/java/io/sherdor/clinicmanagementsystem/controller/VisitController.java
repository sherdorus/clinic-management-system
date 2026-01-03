package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.VisitDTO;
import io.sherdor.clinicmanagementsystem.service.VisitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping
    public ResponseEntity<List<VisitDTO>> getAllVisitors() {
        return ResponseEntity.ok(visitService.findAll());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<VisitDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(visitService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VisitDTO> createVisit(@Valid @RequestBody VisitDTO visitDTO) {
        var createdVisit = visitService.create(visitDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdVisit);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
