package io.sherdor.clinicmanagementsystem.security;

import io.sherdor.clinicmanagementsystem.entity.AppUser;
import io.sherdor.clinicmanagementsystem.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserPrincipalTest {

    @Test
    void shouldReturnUserDetailWhenAccountIsActive(){
        AppUser appUser = AppUser.builder()
                .id(1L)
                .email("doctor@example.com")
                .passwordHash("$2a$12$exampleHash")
                .role(Role.DOCTOR)
                .enabled(true)
                .accountNonLocked(true)
                .build();

        AppUserPrincipal principal = new AppUserPrincipal(appUser);

        assertEquals(1L, principal.getId());
        assertEquals("doctor@example.com", principal.getUsername());
        assertEquals("$2a$12$exampleHash", principal.getPassword());

        assertTrue(principal.isEnabled());
        assertTrue(principal.isAccountNonLocked());

        assertTrue(principal.getAuthorities()
                .stream()
                .anyMatch(authority ->
                        authority.getAuthority().equals("ROLE_DOCTOR")));
    }

    @Test
    void shouldReturnDisabledAccount_whenAccountIsDisabled() {

        AppUser appUser = AppUser.builder()
                .id(2L)
                .email("patient@example.com")
                .passwordHash("$2a$12$exampleHash")
                .role(Role.PATIENT)
                .enabled(false)
                .accountNonLocked(true)
                .build();

        AppUserPrincipal principal = new AppUserPrincipal(appUser);

        assertFalse(principal.isEnabled());
        assertTrue(principal.isAccountNonLocked());
    }

    @Test
    void shouldReturnLockedAccount_whenAccountIsLocked() {

        AppUser appUser = AppUser.builder()
                .id(3L)
                .email("doctor2@example.com")
                .passwordHash("$2a$12$exampleHash")
                .role(Role.DOCTOR)
                .enabled(true)
                .accountNonLocked(false)
                .build();

        AppUserPrincipal principal = new AppUserPrincipal(appUser);

        assertTrue(principal.isEnabled());
        assertFalse(principal.isAccountNonLocked());
    }
}
