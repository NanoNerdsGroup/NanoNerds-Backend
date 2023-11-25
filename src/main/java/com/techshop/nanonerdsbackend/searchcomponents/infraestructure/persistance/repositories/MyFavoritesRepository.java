package com.techshop.nanonerdsbackend.searchcomponents.infraestructure.persistance.repositories;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates.MyFavorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyFavoritesRepository extends JpaRepository<MyFavorites, Long> {
}
