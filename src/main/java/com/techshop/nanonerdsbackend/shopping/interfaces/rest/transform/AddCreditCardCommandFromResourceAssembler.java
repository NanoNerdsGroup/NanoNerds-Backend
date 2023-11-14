package com.techshop.nanonerdsbackend.shopping.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.AddCreditCardCommand;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.AddCreditCardResource;

public class AddCreditCardCommandFromResourceAssembler {


    public static AddCreditCardCommand toCommandFromResource(AddCreditCardResource resource) {
        if (resource == null) {
            return null;
        }

        return new AddCreditCardCommand(
                resource.userId(),
                resource.cardNumber(),
                resource.cardHolder(),
                resource.expirationDate(),
                resource.cvv()
        );
    }
}
