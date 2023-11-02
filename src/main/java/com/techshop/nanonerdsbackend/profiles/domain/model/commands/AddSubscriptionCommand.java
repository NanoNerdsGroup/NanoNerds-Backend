package com.techshop.nanonerdsbackend.profiles.domain.model.commands;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.Subscription;

public record AddSubscriptionCommand(Long userId, Subscription subscription) {
}
