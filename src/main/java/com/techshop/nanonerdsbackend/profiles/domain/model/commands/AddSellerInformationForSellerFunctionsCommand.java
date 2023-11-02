package com.techshop.nanonerdsbackend.profiles.domain.model.commands;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;

public record AddSellerInformationForSellerFunctionsCommand(Long userId, SellerProfile sellerUpdateInformation) {


}
