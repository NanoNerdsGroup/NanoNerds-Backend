package com.techshop.nanonerdsbackend.profiles.application.internal.queryservices;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetUserByIdQuery;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetValidationSellerFunctionsQuery;
import com.techshop.nanonerdsbackend.profiles.domain.services.UserQueryService;
import com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean execute(GetValidationSellerFunctionsQuery query) {
        Optional<User> userOptional = userRepository.findUserById(query.userId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getSellerProfile() != null && user.getSellerProfile().getRuc() != null && user.getSellerProfile().getRuc() != 0) {
                    return true;
            }
        }
        return false;
    }

    @Override
    public Optional<User> execute (GetUserByIdQuery query){
        return userRepository.findUserById(query.userId());
    }


}