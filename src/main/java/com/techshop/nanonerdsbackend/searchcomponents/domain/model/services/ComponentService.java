package com.techshop.nanonerdsbackend.searchcomponents.domain.model.services;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;

import java.util.List;

public interface ComponentService {
    List<Component> getAllComponents();

    Component getComponentById(Long id);

    List<Component> getComponentsByName(String name);

}
