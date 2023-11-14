package com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources;

public record AddCreditCardResource(Long userId,
                                    String cardNumber,
                                    String cardHolder,
                                    String expirationDate,
                                    String cvv) {
}
