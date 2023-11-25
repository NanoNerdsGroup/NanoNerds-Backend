package com.techshop.nanonerdsbackend.administration.interfaces.rest.transform;
import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.administration.interfaces.rest.resource.ComponentResource;

public class ComponentResourceFromEntityAssembler {

    public static ComponentResource toResourceFromEntity(Component component) {
        return new ComponentResource(component.getId(), component.getPrice(), component.getName()
        ,component.getDescription(), component.getDate(), component.getManufacturer(), component.getCompatibility()
        ,component.getType(), component.getAmount(), component.getSoftware());
    }
}
