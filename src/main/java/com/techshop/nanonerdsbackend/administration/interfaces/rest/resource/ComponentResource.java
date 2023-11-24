package com.techshop.nanonerdsbackend.searchcomponents.interfaces.rest.resources;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public record ComponentResource (
         Long id,
         double price,
         String name,
         String description,
         Date date,
         String manufacturer,
         String compatibility,
         String type,
         double amount,
         String software){


}
