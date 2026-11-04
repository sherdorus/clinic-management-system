package io.sherdor.clinicmanagementsystem.repository;

import io.sherdor.clinicmanagementsystem.entity.AppUser;
import io.sherdor.clinicmanagementsystem.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional <AppUser> findByEmailIgnoreCase(String email);
    boolean existsByEmailIgnoreCase(String email);
    boolean existsByRole(Role role);
    boolean existsByDoctor_Id(Long doctorId);
}
