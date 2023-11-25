package com.techshop.nanonerdsbackend.searchcomponents.domain.services;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates.MyFavorites;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.AddComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.DeleteComponentInMyFavoritesCommand;

import java.util.Optional;

public interface MyFavoritesCommandService {

    Optional<MyFavorites> execute(AddComponentInMyFavoritesCommand command);

    Optional<MyFavorites> execute(DeleteComponentInMyFavoritesCommand command);

}
