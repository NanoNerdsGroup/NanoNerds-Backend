package com.techshop.nanonerdsbackend.shopping.domain.model.aggregates;

import com.techshop.nanonerdsbackend.shopping.domain.model.entity.CreditCardEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreditCard {

    private List<CreditCardEntity> creditCardEntities = new ArrayList<>();

    public void addCreditCard(CreditCardEntity creditCardEntity) {
        // para validar y agregar la tarjeta de crédito
        if (isValidCreditCard(creditCardEntity)) {
            creditCardEntities.add(creditCardEntity);
        } else {
            throw new IllegalArgumentException("Invalid credit card information");
        }
    }

    private boolean isValidCreditCard(CreditCardEntity creditCardEntity) {
        // Devuelve true si la tarjeta de crédito es válida
        return isValidCardNumber(creditCardEntity.getCardNumber()) &&
                isValidExpirationDate(creditCardEntity.getExpirationDate()) &&
                isValidCvv(creditCardEntity.getCvv());
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    private boolean isValidExpirationDate(LocalDate expirationDate) {
        return expirationDate != null && !expirationDate.isBefore(LocalDate.now());
    }

    private boolean isValidCvv(String cvv) {
        return cvv != null && cvv.matches("\\d{3}");
    }
}
