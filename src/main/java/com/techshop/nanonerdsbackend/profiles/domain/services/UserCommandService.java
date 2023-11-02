package com.techshop.nanonerdsbackend.profiles.domain.services;

import com.techshop.nanonerdsbackend.profiles.domain.model.commands.AddSellerInformationForSellerFunctionsCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.AddSubscriptionCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.RegisterUserCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.UpdateUserInformationCommand;

public interface UserCommandService {

    boolean execute(UpdateUserInformationCommand command);

    boolean execute(AddSellerInformationForSellerFunctionsCommand command);

    void execute(AddSubscriptionCommand command);

    boolean execute (RegisterUserCommand command);
}
