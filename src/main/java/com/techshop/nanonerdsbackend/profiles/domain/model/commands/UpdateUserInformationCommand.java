package com.techshop.nanonerdsbackend.profiles.domain.model.commands;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.CustomerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.EmailAddress;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PersonName;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PhoneNumber;

public record UpdateUserInformationCommand(Long userId, CustomerProfile customerUpdatedInformation, SellerProfile sellerUpdatedInformation) {
}
