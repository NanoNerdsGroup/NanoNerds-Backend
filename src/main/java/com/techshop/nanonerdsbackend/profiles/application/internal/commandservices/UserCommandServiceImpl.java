package com.techshop.nanonerdsbackend.profiles.application.internal.commandservices;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.AddSellerInformationForSellerFunctionsCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.AddSubscriptionCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.RegisterUserCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.UpdateUserInformationCommand;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.services.UserCommandService;
import com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

public class UserCommandServiceImpl implements UserCommandService {

    UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public boolean execute(UpdateUserInformationCommand command) {
        userRepository.findUserById(command.userId()).map(user -> {
            user.updateUserInformation(command.customerUpdatedInformation(), command.sellerUpdatedInformation());
            userRepository.save(user);
            return true;
        }).orElseThrow(()-> new RuntimeException("User not found"));
        return true;
    }

    @Override
    public boolean execute(AddSellerInformationForSellerFunctionsCommand command){

        Optional<User> userOptional = userRepository.findUserById(command.userId());
        SellerProfile sellerProfile;
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            sellerProfile = user.getSellerProfile();
            if (sellerProfile == null) {
                sellerProfile = new SellerProfile();
            }
            user.updateUserInformation(null, command.sellerUpdateInformation());
            userRepository.save(user);

            return true;
        }

        return false;
    }

    @Override
    public void execute(AddSubscriptionCommand command) {
        userRepository.findUserById(command.userId()).map(user -> {
            user.getSubscriptionPack().addSubscription(command.subscription());
            userRepository.save(user);
            return true;
        }).orElseThrow(()-> new RuntimeException("User not found"));

    }

    @Override
    public boolean execute(RegisterUserCommand command) {
        String firstName = command.firstName();
        String lastName = command.lastName();
        String email = command.email();
        String phone = command.phone();
        String password = command.password();
        String codeCountry = command.codeCountry();
        String phoneNumber = command.phoneNumber();

        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank() ||
                email == null || email.isBlank() || phone == null || phone.isBlank() || password == null
                || password.isBlank() || codeCountry == null || codeCountry.isBlank() || phoneNumber == null
                || phoneNumber.isBlank()) {
            return false;
        }

        User newUser = new User(firstName, lastName, email, phone, password, codeCountry, phoneNumber);
        userRepository.save(newUser);
        return true;
    }

    }

