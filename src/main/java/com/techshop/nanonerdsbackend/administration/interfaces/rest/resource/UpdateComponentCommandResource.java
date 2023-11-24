package com.techshop.nanonerdsbackend.administration.domain.model.commands;

import java.util.Date;

public record UpdateComponentCommand(

        Long id,
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
