package com.techshop.nanonerdsbackend.administration.application.internal.commandservice;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.CreateComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.DeleteComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.model.commands.UpdateComponentCommand;
import com.techshop.nanonerdsbackend.administration.domain.services.ComponentCommandService;
import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.interfaces.acl.UserContextFacade;
import com.techshop.nanonerdsbackend.administration.infraestructure.persistence.repositories.ComponentRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ComponentCommandServiceImpl implements ComponentCommandService {

    private final UserContextFacade userContextFacade;
    private final ComponentRepository componentRepository;

    @Override
    public Optional<Component> execute(CreateComponentCommand command) {
        Optional<User> user = userContextFacade.getUserById(command.userId());

        Component newComponent = new Component();
        newComponent.setPrice(command.price());
        newComponent.setName(command.name());
        newComponent.setDescription(command.description());
        newComponent.setDate(command.date());
        newComponent.setManufacturer(command.manufacturer());
        newComponent.setCompatibility(command.compatibility());
        newComponent.setType(command.type());
        newComponent.setAmount(command.amount());
        newComponent.setSoftware(command.software());


        user.get().getSellerProfile().getComponents().add(newComponent);
        componentRepository.save(newComponent);
        userContextFacade.getUserRepository().save(user.get());
        return Optional.of(newComponent);
    }

    @Override
    public boolean execute(DeleteComponentCommand command) {
        boolean exists = componentRepository.existsById(command.id());
        if (exists) {
            componentRepository.deleteById(command.id());
        }
        return exists;

    }

    @Override
    public Optional<Component> execute(UpdateComponentCommand command) {
        Optional<User> user = userContextFacade.getUserById(command.userId());
        if (!user.isPresent()){
            return Optional.empty();
        }
        Optional<Component> updatedComponent = user.flatMap(u ->
                u.getSellerProfile().getComponents().stream()
                        .filter(component -> component.getId().equals(command.id()))
                        .findFirst()
                        .map(component -> {
                            component.setPrice(command.price());
                            component.setName(command.name());
                            component.setDescription(command.description());
                            component.setDate(command.date());
                            component.setManufacturer(command.manufacturer());
                            component.setCompatibility(command.compatibility());
                            component.setType(command.type());
                            component.setAmount(command.amount());
                            component.setSoftware(command.software());
                            return componentRepository.save(component);
                        })
        );
        return updatedComponent;
    }
}
