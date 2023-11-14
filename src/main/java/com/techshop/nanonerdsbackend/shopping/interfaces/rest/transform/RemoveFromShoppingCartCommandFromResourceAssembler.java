package com.techshop.nanonerdsbackend.shopping.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.RemoveFromShoppingCartCommand;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.RemoveFromShoppingCartResource;

public class RemoveFromShoppingCartCommandFromResourceAssembler {

    public static RemoveFromShoppingCartCommand toCommandFromResource(RemoveFromShoppingCartResource resource) {
        if (resource == null) {
            return null;
        }

        return new RemoveFromShoppingCartCommand(
                resource.userId(),
                resource.itemId()
        );
    }
}
