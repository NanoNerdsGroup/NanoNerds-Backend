package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;

import java.util.Set;

public record MyFavoriteResource(Long id, Set<Component> components) {



}
