package com.anagracetech.backend.auth;

import com.anagracetech.backend.customer.CustomerDTO;

public record AuthenticationResponse (
        String token,
        CustomerDTO customerDTO){
}