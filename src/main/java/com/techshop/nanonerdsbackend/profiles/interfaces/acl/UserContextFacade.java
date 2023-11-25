package com.techshop.nanonerdsbackend.profiles.interfaces.acl;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import com.techshop.nanonerdsbackend.profiles.domain.model.queries.GetUserByIdQuery;
import com.techshop.nanonerdsbackend.profiles.domain.services.UserQueryService;
import com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserContextFacade {

    private final UserQueryService userQueryService;

    @Getter
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id){
        var getUserByIdQuery = new GetUserByIdQuery(id);
        return userQueryService.execute(getUserByIdQuery);
    }


}
