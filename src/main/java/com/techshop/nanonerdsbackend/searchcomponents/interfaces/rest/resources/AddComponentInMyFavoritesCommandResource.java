package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;

public record AddComponentInMyFavoritesCommandResource(Long idMyFavorites, Component newComponent) {
}
