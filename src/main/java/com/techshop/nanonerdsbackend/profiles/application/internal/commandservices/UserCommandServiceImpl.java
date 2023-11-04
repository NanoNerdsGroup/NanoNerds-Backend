package com.techshop.nanonerdsbackend.profiles.application.internal.commandservices;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.commands.*;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.CustomerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.ValidatePremiunSubscriptionQuery;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.EmailAddress;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PersonName;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PhoneNumber;
import com.techshop.nanonerdsbackend.profiles.domain.services.UserCommandService;
import com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories.CustomerProfileRepository;
import com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    UserRepository userRepository;
    CustomerProfileRepository customerProfileRepository;

    public UserCommandServiceImpl(UserRepository userRepository, CustomerProfileRepository customerProfileRepository){

        this.userRepository = userRepository;
        this.customerProfileRepository =  customerProfileRepository;
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
    public Optional<User> execute(RegisterUserCommand command) {

        String firstName = command.firstName();
        String lastName = command.lastName();
        String email = command.email();
        String password = command.password();
        String codeCountry = command.codeCountry();
        String phoneNumber = command.phoneNumber();

        if (firstName == null || firstName.isBlank() || lastName == null || lastName.isBlank() ||
                email == null || email.isBlank() || password == null
                || password.isBlank() || codeCountry == null || codeCountry.isBlank() || phoneNumber == null
                || phoneNumber.isBlank()) {
            return null;
        }

        CustomerProfile newCustomerProfile = new CustomerProfile(new PersonName(firstName, lastName),
                new EmailAddress(email), new PhoneNumber(codeCountry, phoneNumber), password);

        customerProfileRepository.save(newCustomerProfile);
        User newUser = new User(newCustomerProfile);
        userRepository.save(newUser);
        return Optional.of(newUser);
    }

}

