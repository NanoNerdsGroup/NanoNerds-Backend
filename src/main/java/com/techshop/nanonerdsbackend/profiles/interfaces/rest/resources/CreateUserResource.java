package com.techshop.nanonerdsbackend.profiles.interfaces.rest.resources;

public record CreateUserResource(String firstName,
                                 String lastName,
                                 String email,
                                 String phone,
                                 String password,
                                 String codeCountry,
                                 String phoneNumber){
}
