package com.techshop.nanonerdsbackend.searchcomponents.domain.model.rest;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.rest.resources.ComponentResource;

public class ComponentResourceFromEntityAssembler {

    public static ComponentResource toResourceFromEntity(Component entity) {
        ComponentResource resource = new ComponentResource();
        resource.setId(entity.getId());
        resource.setPrice(entity.getPrice());
        resource.setDescription(entity.getDescription());
        return resource;
    }
}
