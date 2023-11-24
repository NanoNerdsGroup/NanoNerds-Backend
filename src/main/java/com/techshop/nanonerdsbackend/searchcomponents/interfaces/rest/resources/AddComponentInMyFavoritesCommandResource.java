package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;

public record AddComponentInMyFavoritesResource(Long idMyFavorites, Component newComponent) {
}
