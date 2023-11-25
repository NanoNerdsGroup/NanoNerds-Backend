package com.techshop.nanonerdsbackend.searchcomponents.domain.model.aggregates;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class MyFavorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch =  FetchType.EAGER, cascade =  CascadeType.ALL)
    @Setter
    private Set<Component> components;

}