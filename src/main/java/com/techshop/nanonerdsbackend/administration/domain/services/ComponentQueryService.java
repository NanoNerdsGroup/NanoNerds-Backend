package com.techshop.nanonerdsbackend.administration.domain.services;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.administration.domain.model.queries.GetComponentByIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByNameQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByRequirementQuery;

import java.util.List;
import java.util.Optional;

public interface ComponentQueryService {

    Optional<Component> execute(GetComponentByIdQuery query);

    List<Component> execute(GetComponentsByNameQuery query);

    List<Component> execute(GetComponentsByRequirementQuery query);

}
