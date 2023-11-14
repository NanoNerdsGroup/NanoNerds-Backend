package com.techshop.nanonerdsbackend.shopping.domain.services;

import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.AddCreditCardCommand;
import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.AddToShoppingCartCommand;
import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.RemoveFromShoppingCartCommand;

public interface ShoppingCommandService {

    void addToShoppingCart(AddToShoppingCartCommand command);

    void removeFromShoppingCart(RemoveFromShoppingCartCommand command);

    void addCreditCard(AddCreditCardCommand command);

}
