package com.techshop.nanonerdsbackend.profiles.application.internal.queryservices;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.Subscription;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.*;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.SuscriptionPack;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.TypeSubscription;
import com.techshop.nanonerdsbackend.profiles.domain.services.UserQueryService;
import com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
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
    public Optional<User> execute(GetUserByIdQuery query) {
        return userRepository.findUserById(query.userId());
    }

    @Override
    public boolean execute(ValidatePremiunSubscriptionQuery command) {
        return userRepository.findUserById(command.idUser()).map(user -> {
            if (user.getSubscriptionPack().getSubscriptions().stream()
                    .anyMatch(subscription -> subscription.getSubscriptionType() == TypeSubscription.PREMIUM)) {
                return true;
            }
            return false;
        }).orElse(false);

    }

    @Override
    public boolean execute(ValidateEnterpriseSubscriptionQuery command) {
        return userRepository.findUserById(command.idUser()).map(user -> {
            if (user.getSubscriptionPack().getSubscriptions().stream()
                    .anyMatch(subscription -> subscription.getSubscriptionType() == TypeSubscription.ENTERPRISE)) {
                return true;
            }
            return false;
        }).orElse(false);
    }

    @Override
    public int execute(GetAvailableDaysPremiunSubscriptionByUserIdQuery command) {
        Optional<User> userOptional = userRepository.findUserById(command.userId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            SuscriptionPack subscriptionPack = user.getSubscriptionPack();
            List<Subscription> subscriptions = subscriptionPack.getSubscriptions();

            Date currentDate = new Date();

            for (Subscription subscription : subscriptions) {
                if (subscription.getSubscriptionType() == TypeSubscription.PREMIUM && subscription.getExpiresAt().after(currentDate)) {
                    Long premiumSubscriptionId = subscription.getId();
                    Long remainingDays = subscriptionPack.getAvailableDaysByIdSubscription(premiumSubscriptionId);
                    return remainingDays.intValue();
                }
            }
        }


        return 0;
    }

    @Override
    public int execute(GetAvailableDaysEnterpriseSubscriptionByUserIdQuery command) {
        Optional<User> userOptional = userRepository.findUserById(command.userId());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            SuscriptionPack subscriptionPack = user.getSubscriptionPack();
            List<Subscription> subscriptions = subscriptionPack.getSubscriptions();

            Date currentDate = new Date();

            for (Subscription subscription : subscriptions) {
                if (subscription.getSubscriptionType() == TypeSubscription.ENTERPRISE && subscription.getExpiresAt().after(currentDate)) {
                    Long enterpriseSubscriptionId = subscription.getId();
                    Long remainingDays = subscriptionPack.getAvailableDaysByIdSubscription(enterpriseSubscriptionId);
                    return remainingDays.intValue();
                }
            }
        }

        return 0;
    }

}


