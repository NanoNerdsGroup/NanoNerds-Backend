package com.techshop.nanonerdsbackend.shopping.infraestructure.persistence.jpa.repositories;



import com.techshop.nanonerdsbackend.shopping.domain.model.aggregates.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserId(Long userId);
}

