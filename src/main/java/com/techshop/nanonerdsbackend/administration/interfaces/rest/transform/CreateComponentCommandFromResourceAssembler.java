package com.techshop.nanonerdsbackend.administration.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.administration.domain.model.commands.CreateComponentCommand;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.CreateComponentCommandResource;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.AddComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.AddComponentInMyFavoritesCommandResource;

public class CreateComponentCommandFromResourceAssembler {

    public static CreateComponentCommand toCommandFromResource(CreateComponentCommandResource resource) {
        return new CreateComponentCommand(resource.price(), resource.name(), resource.description(),
                resource.date(), resource.manufacturer(), resource.compatibility(), resource.type(),
                resource.amount(), resource.software(), resource.userId());
    }

}
