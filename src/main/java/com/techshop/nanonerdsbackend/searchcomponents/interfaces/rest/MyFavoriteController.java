package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates.MyFavorites;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetMyFavoritesByIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.model.queries.GetMyFavoritesByUserIdQuery;
import com.techshop.nanonerdsbackend.searchcomponents.domain.services.MyFavoritesCommandService;
import com.techshop.nanonerdsbackend.searchcomponents.domain.services.MyFavoritesQueryService;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.AddComponentInMyFavoritesCommandResource;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.DeleteComponentInMyFavoritesCommandResource;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources.MyFavoriteResource;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.transform.AddComponentInMyFavoritesCommandFromResourceAssembler;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.transform.DeleteComponentInMyFavoritesCommandFromResourceAssembler;
import com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.transform.MyFavoriteResourceFromEntityAssembler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/myfavorites", produces = MediaType.APPLICATION_JSON_VALUE)
public class MyFavoriteController {

    private final MyFavoritesQueryService myFavoritesQueryService;
    private final MyFavoritesCommandService myFavoritesCommandService;

    //GET
    @GetMapping("/my-favorites/{userId}")
    public ResponseEntity<MyFavoriteResource> getMyFavoriteById(@PathVariable Long userId){
        var getMyFavoritesByUserId = new GetMyFavoritesByUserIdQuery(userId);
        var myFavorite = myFavoritesQueryService.execute(getMyFavoritesByUserId);
        if (myFavorite.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var myFavoriteResource = MyFavoriteResourceFromEntityAssembler.toResourceFromEntity(myFavorite.get());
        return ResponseEntity.ok(myFavoriteResource);
    }

    //POST
    @PostMapping("/add-component-myfavorite")
    public ResponseEntity<MyFavoriteResource> addComponentInMyFavorite(@RequestBody AddComponentInMyFavoritesCommandResource resource){
        var addComponentInMyFavorites = AddComponentInMyFavoritesCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<MyFavorites> myFavorites = myFavoritesCommandService.execute(addComponentInMyFavorites);
        if (myFavorites.get() == null) {
            return ResponseEntity.badRequest().build();
        }

        var getMyFavoritesByIdQuery = new GetMyFavoritesByIdQuery(myFavorites.get().getId());
        Optional<MyFavorites> newMyFavorites = myFavoritesQueryService.execute(getMyFavoritesByIdQuery);

        if (newMyFavorites.get() == null){
            return ResponseEntity.badRequest().build();
        }

        var myFavoritesResource = MyFavoriteResourceFromEntityAssembler.toResourceFromEntity(newMyFavorites.get());
        return new ResponseEntity<>(myFavoritesResource, HttpStatus.CREATED);
    }


    @PostMapping("/delete-component-myfavorite")
    public ResponseEntity<MyFavoriteResource> deleteComponentInMyFavorite(@RequestBody DeleteComponentInMyFavoritesCommandResource resource){
        var deleteComponentInMyFavorites = DeleteComponentInMyFavoritesCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<MyFavorites> myFavorites = myFavoritesCommandService.execute(deleteComponentInMyFavorites);
        if (myFavorites.get() == null) {
            return ResponseEntity.badRequest().build();
        }

        var getMyFavoritesByIdQuery = new GetMyFavoritesByIdQuery(myFavorites.get().getId());
        Optional<MyFavorites> newMyFavorites = myFavoritesQueryService.execute(getMyFavoritesByIdQuery);

        if (newMyFavorites.get() == null){
            return ResponseEntity.badRequest().build();
        }

        var myFavoritesResource = MyFavoriteResourceFromEntityAssembler.toResourceFromEntity(newMyFavorites.get());
        return new ResponseEntity<>(myFavoritesResource, HttpStatus.CREATED);
    }




}
