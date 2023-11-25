package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.AddComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.DeleteComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.AddComponentInMyFavoritesCommandResource;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.DeleteComponentInMyFavoritesCommandResource;

public class DeleteComponentInMyFavoritesCommandFromResourceAssembler {

    public static DeleteComponentInMyFavoritesCommand toCommandFromResource(DeleteComponentInMyFavoritesCommandResource resource) {
        return new DeleteComponentInMyFavoritesCommand(resource.idMyFavorites(), resource.idComponent());
    }

}
