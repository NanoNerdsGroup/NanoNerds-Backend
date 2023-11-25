package com.techshop.nanonerdsbackend.administration.infraestructure.persistence.repositories;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    Optional<Component> findComponentById(Long id);
    List<Component> findByNameContainingIgnoreCase(String name);

    List<Component> findBySoftwareAndTypeAndPriceLessThanEqual(String software, String type, double budget);


}