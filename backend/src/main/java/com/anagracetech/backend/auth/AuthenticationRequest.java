package com.anagracetech.backend.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
