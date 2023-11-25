package com.techshop.nanonerdsbackend.profiles.domain.services;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.*;

import java.util.Optional;

public interface UserCommandService {

    Optional<User> execute(UpdateUserInformationCommand command);

    Optional<User> execute(AddSellerInformationForSellerFunctionsCommand command);

    void execute(AddSubscriptionCommand command);

    Optional<User> execute(RegisterUserCommand command);
}
