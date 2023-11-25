package com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;

public record AddComponentInMyFavoritesCommand(Long idMyFavorites, Component newComponent) {
}
