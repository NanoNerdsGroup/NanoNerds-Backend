package com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.Subscription;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Embeddable
@Getter
public class SuscriptionPack {

    @OneToMany
    private List<Subscription> subscriptions;

    public SuscriptionPack(){
        this.subscriptions = new ArrayList<Subscription>();
    }

    public void addSubscription(Subscription newSubscription){
        Subscription subscription = new Subscription(newSubscription.getSubscriptionType(),
                newSubscription.getBenefits(), newSubscription.getPrice(), newSubscription.getPurchasedAt(),
                newSubscription.getExpiresAt());
        subscriptions.add(subscription);
    }

    public Long getAvailableDaysByIdSubscription(Long id){
        return subscriptions.stream().filter(subscription -> subscription.getId() == id)
                .findFirst().orElse(null).getDurationInDays();
    }




}
