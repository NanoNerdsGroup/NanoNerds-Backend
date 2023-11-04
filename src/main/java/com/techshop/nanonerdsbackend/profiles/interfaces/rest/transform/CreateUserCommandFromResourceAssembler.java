package com.techshop.nanonerdsbackend.profiles.interfaces.rest.transform;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.RegisterUserCommand;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources.CreateUserResource;


public class CreateUserCommandFromResourceAssembler {

           public static RegisterUserCommand toCommandFromResource(CreateUserResource resource) {
               return new RegisterUserCommand(
                       resource.firstName(),
                       resource.lastName(),
                       resource.email(),
                       resource.password(),
                       resource.codeCountry(),
                       resource.phoneNumber()
               );
           }
}
