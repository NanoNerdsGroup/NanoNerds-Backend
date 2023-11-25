package com.techshop.nanonerdsbackend.administration.domain.services;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.CreateComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.DeleteComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.UpdateComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.queries.GetComponentByIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByNameQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByRequirementQuery;

import java.util.List;
import java.util.Optional;

public interface ComponentCommandService {

    Optional<Component> execute(CreateComponentCommand command);

    boolean execute(DeleteComponentCommand command);

    Optional<Component> execute(UpdateComponentCommand command);

}
