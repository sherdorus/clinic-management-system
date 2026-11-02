package io.sherdor.clinicmanagementsystem.security;

import io.sherdor.clinicmanagementsystem.entity.AppUser;
import io.sherdor.clinicmanagementsystem.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AppUserPrincipal implements UserDetails {

    private final Long id;
    private final String email;
    private final String passwordHash;
    private final Role role;
    private final Long patientId;
    private final Long doctorId;
    private final boolean enabled;
    private final boolean accountNonLocked;

    public AppUserPrincipal(AppUser appUser) {
        this.id = appUser.getId();
        this.email = appUser.getEmail();
        this.passwordHash = appUser.getPasswordHash();
        this.role = appUser.getRole();
        this.enabled = appUser.isEnabled();
        this.accountNonLocked = appUser.isAccountNonLocked();

        this.patientId = appUser.getPatient() != null
                ? appUser.getPatient().getId()
                : null;

        this.doctorId = appUser.getDoctor() != null
                ? appUser.getDoctor().getId()
                : null;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + role.name())
        );
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}