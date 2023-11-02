package com.techshop.nanonerdsbackend.searchcomponents.domain.model.valueobjects;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.Subscription;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ComponentsPackMyFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Component> Components;

    public ComponentsPackMyFavorite(){
        this.Components = new ArrayList<Component>();
    }





}
