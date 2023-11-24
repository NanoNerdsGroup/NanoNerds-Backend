package com.techshop.nanonerdsbackend.searchcomponents.domain.model.infraestructure;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    List<Component> findByDescriptionIgnoreCaseContaining(String name);
}