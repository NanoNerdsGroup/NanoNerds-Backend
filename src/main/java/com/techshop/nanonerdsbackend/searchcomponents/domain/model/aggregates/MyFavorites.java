package com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates;

import jakarta.persistence.*;

@Entity
public class MyFavorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
