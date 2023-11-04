package com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.CustomerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.Subscription;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.SuscriptionPack;

public record UserResource(Long id, CustomerProfile customerProfile, SellerProfile sellerProfile, SuscriptionPack suscriptionPack) {
}
