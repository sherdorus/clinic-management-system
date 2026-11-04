package io.sherdor.clinicmanagementsystem.service;

import io.sherdor.clinicmanagementsystem.dto.request.CreateChiefDoctorRequest;
import io.sherdor.clinicmanagementsystem.entity.AppUser;
import io.sherdor.clinicmanagementsystem.enums.Role;
import io.sherdor.clinicmanagementsystem.repository.AppUserRepository;
import io.sherdor.clinicmanagementsystem.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ChiefDoctorService {

    private final AppUserRepository appUserRepository;
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;

    public ChiefDoctorService(AppUserRepository appUserRepository, DoctorRepository doctorRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createChiefDoctor(CreateChiefDoctorRequest request){
        if (appUserRepository.existsByRole(Role.CHIEF_DOCTOR)){
            throw new IllegalStateException("A chief doctor already exists");
        }
        if (appUserRepository.existsByEmailIgnoreCase(request.email())){
            throw new IllegalArgumentException("An account with this email already exists");
        }

        var doctor = doctorRepository.findById(request.doctorId())
                .orElseThrow(() -> new IllegalArgumentException("Doctor not found with ID: " + request.doctorId()));

        if (appUserRepository.existsByDoctor_Id(request.doctorId())) {
            throw new IllegalStateException(
                    "This doctor already has an account"
            );
    }

        AppUser chiefDoctor = AppUser.builder()
                .email(request.email())
                .passwordHash(passwordEncoder.encode(request.password()))
                .role(Role.CHIEF_DOCTOR)
                .doctor(doctor)
                .enabled(true)
                .accountNonLocked(true)
                .build();

        appUserRepository.save(chiefDoctor);
    }
}
