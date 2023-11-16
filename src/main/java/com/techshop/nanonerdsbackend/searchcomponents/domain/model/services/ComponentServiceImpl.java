package com.techshop.nanonerdsbackend.searchcomponents.domain.model.services;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.infraestructure.ComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {

    private final ComponentRepository componentRepository;

    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    @Override
    public List<Component> getAllComponents() {
        return componentRepository.findAll();
    }

    @Override
    public Component getComponentById(Long id) {
        return componentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Component> getComponentsByName(String name) {
        return componentRepository.findByDescriptionIgnoreCaseContaining(name);
    }

}
