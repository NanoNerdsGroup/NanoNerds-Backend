package com.techshop.nanonerdsbackend.shopping.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.AddToShoppingCartCommand;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.AddToShoppingCartResource;

public class AddToShoppingCartCommandFromResourceAssembler {


    public static AddToShoppingCartCommand toCommandFromResource(AddToShoppingCartResource resource) {
        if (resource == null) {
            return null;
        }


        return new AddToShoppingCartCommand(

                resource.userId(),
                resource.componentId(),
                resource.quantity()
        );
    }
}
