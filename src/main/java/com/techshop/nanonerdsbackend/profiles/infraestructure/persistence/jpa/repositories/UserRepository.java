package com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories;

import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long userId);


}
