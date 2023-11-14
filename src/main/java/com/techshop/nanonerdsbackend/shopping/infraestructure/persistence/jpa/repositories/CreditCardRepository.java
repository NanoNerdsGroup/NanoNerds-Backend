package com.techshop.nanonerdsbackend.shopping.infraestructure.persistence.jpa.repositories;


import com.techshop.nanonerdsbackend.shopping.domain.model.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {


}
