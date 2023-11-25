package com.techshop.nanonerdsbackend.administration.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.administration.domain.model.commands.UpdateComponentCommand;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.UpdateComponentCommandResource;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.AddComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.AddComponentInMyFavoritesCommandResource;

public class UpdateComponentCommandFromResourceAssembler {

    public static UpdateComponentCommand toCommandFromResource(UpdateComponentCommandResource resource) {
        return new UpdateComponentCommand(resource.userId(), resource.price(), resource.name(), resource.description(), resource.date(),
                resource.manufacturer(), resource.compatibility(), resource.type(), resource.amount(), resource.software(), resource.userId());
    }

}
