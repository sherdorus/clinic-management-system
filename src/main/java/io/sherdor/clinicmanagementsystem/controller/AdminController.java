package io.sherdor.clinicmanagementsystem.controller;

import io.sherdor.clinicmanagementsystem.dto.request.CreateChiefDoctorRequest;
import io.sherdor.clinicmanagementsystem.service.ChiefDoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final ChiefDoctorService chiefDoctorService;

    public AdminController(ChiefDoctorService chiefDoctorService) {
        this.chiefDoctorService = chiefDoctorService;
    }

    @PostMapping("/chief-doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public void createChiefDoctor(@Valid @RequestBody CreateChiefDoctorRequest request){
        chiefDoctorService.createChiefDoctor(request);
    }
}
