package com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class Components {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private double price;
    private String description;
    private Date date;
    private String manufacturer;
    private String compatibility;
    private String type;
    private int amount;

}
