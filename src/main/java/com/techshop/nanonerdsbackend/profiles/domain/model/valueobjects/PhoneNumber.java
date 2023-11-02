package com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PhoneNumber(String codeCountry, String phoneNumber) {

    public PhoneNumber() {
        this(null, null);
    }

    public PhoneNumber {
        if (codeCountry == null || codeCountry.isBlank()) {
            throw new IllegalArgumentException("Country code cannot be null or blank");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
    }
    
    public String getFullPhoneNumber(){return codeCountry + " " + phoneNumber;}
    
}
