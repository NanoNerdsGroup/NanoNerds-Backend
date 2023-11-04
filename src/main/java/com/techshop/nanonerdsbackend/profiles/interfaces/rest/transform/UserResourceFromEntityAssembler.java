package com.techshop.nanonerdsbackend.profiles.interfaces.rest.transform;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler{

    public static UserResource toResourceFromEntity(User user){
        return new UserResource(user.getId(), user.getCustomerProfile(), user.getSellerProfile(), user.getSubscriptionPack());
    }

}
