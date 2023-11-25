package com.techshop.nanonerdsbackend.profiles.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.profiles.domain.model.commands.RegisterUserCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.UpdateUserInformationCommand;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources.CreateUserResource;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources.UpdateUserResource;

public class UpdateUserResourceAssembler {

    public static UpdateUserInformationCommand toCommandFromResource(UpdateUserResource resource) {
        return new UpdateUserInformationCommand(resource.id(),resource.customerUpdatedProfile(),resource.sellerUpdatedProfile());
    }

}
