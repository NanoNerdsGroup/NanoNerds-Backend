package com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.CustomerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;

public record UpdateUserResource(
        Long id,
        CustomerProfile customerUpdatedProfile,
        SellerProfile sellerUpdatedProfile
) {
}
