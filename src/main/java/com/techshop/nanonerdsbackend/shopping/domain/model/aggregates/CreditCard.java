package com.techshop.nanonerdsbackend.shopping.domain.model.aggregates;

import com.techshop.nanonerdsbackend.shopping.domain.model.entity.CreditCardEntity;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private List<CreditCardEntity> creditCardEntities = new ArrayList<>();

    public void addCreditCard(CreditCardEntity creditCardEntity) {
        // Lógica para validar y agregar la tarjeta de crédito
        if (isValidCreditCard(creditCardEntity)) {
            creditCardEntities.add(creditCardEntity);
        }else {
            throw new IllegalArgumentException("Invalid credit card information");
        }
    }

    private boolean isValidCreditCard(CreditCardEntity creditCardEntity) {

        return false;
    }
}