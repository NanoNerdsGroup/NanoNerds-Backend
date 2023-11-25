package com.techshop.nanonerdsbackend.searchcomponents.application.internal.commandservice;

import com.techshop.nanonerdsbackend.profiles.interfaces.acl.UserContextFacade;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates.MyFavorites;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.AddComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.commands.DeleteComponentInMyFavoritesCommand;
import com.techshop.nanonerdsbackend.searchcomponents.domain.services.MyFavoritesCommandService;
import com.techshop.nanonerdsbackend.searchcomponents.infraestructure.persistance.repositories.MyFavoritesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MyFavoritesCommandServiceImpl implements MyFavoritesCommandService {

    private final MyFavoritesRepository myFavoritesRepository;
    private final UserContextFacade userContextFacade;

    @Override
    public Optional<MyFavorites> execute(AddComponentInMyFavoritesCommand command) {
        return myFavoritesRepository.findById(command.idMyFavorites()).map(myFavorites -> {
            myFavorites.getComponents().add(command.newComponent());
            return myFavoritesRepository.save(myFavorites);
        });
    }

    @Override
    public Optional<MyFavorites> execute(DeleteComponentInMyFavoritesCommand command) {
        return myFavoritesRepository.findById(command.idMyFavorites()).map(myFavorites -> {
            myFavorites.setComponents(
                    myFavorites.getComponents().stream()
                            .filter(component -> !component.getId().equals(command.idComponent()))
                            .collect(Collectors.toSet())
            );
            return myFavoritesRepository.save(myFavorites);
        });
    }
}
