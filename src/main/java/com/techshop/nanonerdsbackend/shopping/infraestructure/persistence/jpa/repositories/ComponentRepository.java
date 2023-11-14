package com.techshop.nanonerdsbackend.shopping.infraestructure.persistence.jpa.repositories;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
}
