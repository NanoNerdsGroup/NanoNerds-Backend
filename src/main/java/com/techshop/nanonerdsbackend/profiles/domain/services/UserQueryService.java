package com.techshop.nanonerdsbackend.profiles.domain.services;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetUserByIdQuery;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetValidationSellerFunctionsQuery;

import java.util.Optional;

public interface UserQueryService {

    boolean execute (GetValidationSellerFunctionsQuery query);

    Optional<User> execute (GetUserByIdQuery query);

}
