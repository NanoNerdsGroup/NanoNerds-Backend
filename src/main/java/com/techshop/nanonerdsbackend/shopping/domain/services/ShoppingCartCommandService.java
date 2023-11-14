package com.techshop.nanonerdsbackend.shopping.domain.services;

import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.AddToShoppingCartCommand;
import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.RemoveFromShoppingCartCommand;

public interface ShoppingCartCommandService {

    void addToShoppingCart(AddToShoppingCartCommand command);

    void removeFromShoppingCart(RemoveFromShoppingCartCommand command);

}
