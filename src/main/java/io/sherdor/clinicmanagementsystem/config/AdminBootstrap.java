package io.sherdor.clinicmanagementsystem.config;

import io.sherdor.clinicmanagementsystem.entity.AppUser;
import io.sherdor.clinicmanagementsystem.enums.Role;
import io.sherdor.clinicmanagementsystem.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminBootstrap {

    @Bean
    public CommandLineRunner createInitialAdmin(AppUserRepository appUserRepository,
                                                PasswordEncoder passwordEncoder,
                                                @Value("${app.bootstrap-admin.email:}") String adminEmail,
                                                @Value("${app.bootstrap-admin.password:}") String adminPassword) {

        return args -> {
            if (adminEmail.isBlank() || adminPassword.isBlank()) {
                throw new IllegalStateException("Bootstrap admin email and password must be configured");
            }
            var existingAdmin = appUserRepository.findByEmailIgnoreCase(adminEmail);

            if (existingAdmin.isPresent()){
                if (existingAdmin.get().getRole() != Role.ADMIN){
                    throw new IllegalStateException("Configured bootstrap admin email belongs to a non-admin user");
                }
                return;
            }
            AppUser admin = AppUser.builder()
                    .email(adminEmail)
                    .passwordHash(passwordEncoder.encode(adminPassword))
                    .role(Role.ADMIN)
                    .enabled(true)
                    .accountNonLocked(true)
                    .build();
            appUserRepository.save(admin);
        };
    }
}
