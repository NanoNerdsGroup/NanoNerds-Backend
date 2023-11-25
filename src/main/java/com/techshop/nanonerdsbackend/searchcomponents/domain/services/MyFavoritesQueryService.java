package com.techshop.nanonerdsbackend.searchcomponents.domain.services;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates.MyFavorites;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetMyFavoritesByIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetMyFavoritesByUserIdQuery;

import java.util.Optional;

public interface MyFavoritesQueryService {

    Optional<MyFavorites> execute (GetMyFavoritesByIdQuery query);

    Optional<MyFavorites> execute (GetMyFavoritesByUserIdQuery query);

}
