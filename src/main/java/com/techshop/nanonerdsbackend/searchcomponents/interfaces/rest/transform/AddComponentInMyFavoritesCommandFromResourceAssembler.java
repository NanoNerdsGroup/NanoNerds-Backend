package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.AddComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.AddComponentInMyFavoritesCommandResource;

public class AddComponentInMyFavoritesCommandFromResourceAssembler {

    public static AddComponentInMyFavoritesCommand toCommandFromResource(AddComponentInMyFavoritesCommandResource resource) {
        return new AddComponentInMyFavoritesCommand(resource.idMyFavorites(), resource.newComponent());
    }

}
