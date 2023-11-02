package com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long userId);

}
