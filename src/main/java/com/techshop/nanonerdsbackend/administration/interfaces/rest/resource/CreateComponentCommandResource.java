package com.techshop.nanonerdsbackend.administration.interfaces.rest.resource;

import java.util.Date;

public record CreateComponentCommandResource(
        double price,
        String name,
        String description,
        Date date,
        String manufacturer,
        String compatibility,
        String type,
        double amount,
        String software,
        Long userId
) {
}
