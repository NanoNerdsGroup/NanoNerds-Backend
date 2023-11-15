package com.techshop.nanonerdsbackend.profiles.domain.services;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.*;

import java.util.Optional;

public interface UserCommandService {

    boolean execute(UpdateUserInformationCommand command);

    boolean execute(AddSellerInformationForSellerFunctionsCommand command);

    void execute(AddSubscriptionCommand command);

    Optional<User> execute(RegisterUserCommand command);

    void addToFavorites(Long userId, Long componentId);
}
