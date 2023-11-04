package com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates;

import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
public class MyFavorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}