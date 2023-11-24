package com.techshop.nanonerdsbackend.searchcomponents.application.internal.queryservice;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.administration.domain.model.queries.GetComponentByIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByNameQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetComponentsByRequirementQuery;
import com.techshop.nanonerdsbackend.administration.domain.services.ComponentQueryService;
import com.techshop.nanonerdsbackend.administration.infraestructure.persistence.repositories.ComponentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ComponentQueryServiceImpl implements ComponentQueryService {

    private final ComponentRepository componentRepository;


    @Override
    public Optional<Component> execute(GetComponentByIdQuery query) {
        return componentRepository.findComponentById(query.id()).filter(Objects::nonNull);
    }

    @Override
    public List<Component> execute(GetComponentsByNameQuery query) {
        return componentRepository.findByNameContainingIgnoreCase(query.searchedName());
    }

    @Override
    public List<Component> execute(GetComponentsByRequirementQuery query) {
        return componentRepository.findBySoftwareAndTypeAndPriceLessThanEqual(query.requirement().getSoftware(),
        query.requirement().getType(), query.requirement().getBudget());
    }
}
