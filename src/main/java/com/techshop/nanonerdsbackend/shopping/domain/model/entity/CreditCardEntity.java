package com.techshop.nanonerdsbackend.shopping.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @NotBlank(message = "El número de tarjeta no puede estar en blanco")
    private String cardNumber;

    @NotBlank(message = "El titular de la tarjeta no puede estar en blanco")
    private String cardHolder;

    private LocalDate expirationDate;

    @NotBlank(message = "El CVV no puede estar en blanco")
    private String cvv;

    public CreditCardEntity() {
    }

    public CreditCardEntity(Long userId, String cardNumber, String cardHolder, LocalDate expirationDate, String cvv) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;

    }

}
