package com.techshop.nanonerdsbackend.shopping.domain.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String cardNumber;
    private String cardHolder;
    private String expirationDate;
    private String cvv;

    public CreditCardEntity() {

    }

    public CreditCardEntity(Long userId, String cardNumber, String cardHolder, String expirationDate, String cvv) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }
}
