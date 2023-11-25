package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates.MyFavorites;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.MyFavoriteResource;

public class MyFavoriteResourceFromEntityAssembler {

    public static MyFavoriteResource toResourceFromEntity(MyFavorites myFavorites){
        return new MyFavoriteResource(myFavorites.getId(), myFavorites.getComponents());
    }
}
