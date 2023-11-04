package com.techshop.nanonerdsbackend.profiles.domain.model.commands;

public record RegisterUserCommand(
        String firstName,
        String lastName,
        String email,
        String password,
        String codeCountry,
        String phoneNumber
) {
}

