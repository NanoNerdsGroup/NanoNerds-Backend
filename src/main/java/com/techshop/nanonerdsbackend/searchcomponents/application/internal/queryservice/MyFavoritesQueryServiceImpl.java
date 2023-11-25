package com.techshop.nanonerdsbackend.searchcomponents.application.internal.queryservice;

import com.techshop.nanonerdsbackend.profiles.interfaces.acl.UserContextFacade;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates.MyFavorites;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetMyFavoritesByIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetMyFavoritesByUserIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.services.MyFavoritesQueryService;
import com.techshop.nanonerdsbackend.searchcomponents.infraestructure.persistance.repositories.MyFavoritesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MyFavoritesQueryServiceImpl implements MyFavoritesQueryService {

    private final MyFavoritesRepository myFavoritesRepository;
    private final UserContextFacade userContextFacade;

    @Override
    public Optional<MyFavorites> execute(GetMyFavoritesByIdQuery query) {
        return myFavoritesRepository.findById(query.id());
    }

    @Override
    public Optional<MyFavorites> execute(GetMyFavoritesByUserIdQuery query) {
        return userContextFacade.getUserById(query.userId())
                .map(user -> user.getMyFavorites())
                .filter(Objects::nonNull);
    }




}
