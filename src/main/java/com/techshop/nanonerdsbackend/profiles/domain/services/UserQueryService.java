package com.techshop.nanonerdsbackend.profiles.domain.services;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.*;

import java.util.Optional;

public interface UserQueryService {

    Optional<User> execute (GetValidationSellerFunctionsQuery query);

    Optional<User> execute (GetUserByIdQuery query);

    boolean execute (ValidatePremiunSubscriptionQuery command);

    boolean execute (ValidateEnterpriseSubscriptionQuery command);

    int execute (GetAvailableDaysPremiunSubscriptionByUserIdQuery command );

    int execute (GetAvailableDaysEnterpriseSubscriptionByUserIdQuery command );
}
