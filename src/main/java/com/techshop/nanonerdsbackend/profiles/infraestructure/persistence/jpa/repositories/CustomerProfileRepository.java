package com.techshop.nanonerdsbackend.profiles.infraestructure.persistence.jpa.repositories;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {


}
