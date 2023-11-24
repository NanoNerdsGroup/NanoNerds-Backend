package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.transform;
import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.ComponentResource;

public class ComponentResourceFromEntityAssembler {

    public static ComponentResource toResourceFromEntity(Component component) {
        return new ComponentResource(component.getId(), component.getPrice(), component.getName()
        ,component.getDescription(), component.getDate(), component.getManufacturer(), component.getCompatibility()
        ,component.getType(), component.getAmount(), component.getSoftware());
    }
}
