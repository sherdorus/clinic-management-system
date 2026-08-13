package io.sherdor.clinicmanagementsystem.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String message,
        String path) {

    public ErrorResponse(String message, int status, String path) {
        this(LocalDateTime.now(), status, message, path);
    }
}
