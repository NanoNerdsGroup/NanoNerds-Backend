package com.techshop.nanonerdsbackend.shopping.domain.model.Commands;

public record AddCreditCardCommand(
        Long userId,
        String cardNumber,
        String cardHolder,
        String expirationDate,
        String cvv) {
}
