package com.anagracetech.backend.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}