package com.techshop.nanonerdsbackend.profiles.interfaces.rest;

import com.techshop.nanonerdsbackend.profiles.domain.exceptions.ComponentNotFoundException;
import com.techshop.nanonerdsbackend.profiles.domain.exceptions.UserNotFoundException;
import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetUserByIdQuery;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetValidationSellerFunctionsQuery;
import com.techshop.nanonerdsbackend.profiles.domain.services.UserCommandService;
import com.techshop.nanonerdsbackend.profiles.domain.services.UserQueryService;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources.CreateUserResource;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources.UpdateUserResource;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources.UserResource;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.transform.UpdateUserResourceAssembler;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@RestController
@RequestMapping(value = "/api/v1/profile", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileController {

    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public ProfileController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    // GET
    @GetMapping("/{userId}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.execute(getUserByIdQuery);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @GetMapping("/validate-seller-information/{userId}")
    public ResponseEntity<UserResource> getValidationOfSellerInformation(@PathVariable Long userId) {
        var getValidationSellerFunctionsQuery= new GetValidationSellerFunctionsQuery(userId);
        var user = userQueryService.execute(getValidationSellerFunctionsQuery);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    // POST
    @PostMapping("/register")
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource) {
        var registerUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<User> user = userCommandService.execute(registerUserCommand);

        if (user.get() == null) {
            return ResponseEntity.badRequest().build();
        }

        var getUserByIdQuery = new GetUserByIdQuery(user.get().getId());
        Optional<User> userRegistered = userQueryService.execute(getUserByIdQuery);

        if (userRegistered.get() == null) {
            return ResponseEntity.badRequest().build();
        }

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(userRegistered.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<UserResource> updateUser(@RequestBody UpdateUserResource resource){
        var updateUserCommand = UpdateUserResourceAssembler.toCommandFromResource(resource);
        Optional<User> user = userCommandService.execute(updateUserCommand);

        if (user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var getUserByIdQuery = new GetUserByIdQuery(user.get().getId());
        Optional<User> userUpdated = userQueryService.execute(getUserByIdQuery);

        if (userUpdated.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(userUpdated.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }



    /* POST - Agregar a favoritos
    @PostMapping("/add-to-favorites/{userId}/{componentId}")
    public ResponseEntity<String> addToFavorites(@PathVariable Long userId, @PathVariable Long componentId) {
        try {
            userCommandService.addToFavorites(userId, componentId);
            return ResponseEntity.ok("Componente añadido a favoritos con éxito");
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ComponentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }*/
}
