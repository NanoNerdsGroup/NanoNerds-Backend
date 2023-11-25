package com.techshop.nanonerdsbackend.administration.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.administration.domain.model.commands.DeleteComponentCommand;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.DeleteComponentCommandResource;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.AddComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.AddComponentInMyFavoritesCommandResource;

public class DeleteComponentCommandFromResourceAssembler {

    public static DeleteComponentCommand toCommandFromResource(DeleteComponentCommandResource resource) {
        return new DeleteComponentCommand(resource.id());
    }

}
