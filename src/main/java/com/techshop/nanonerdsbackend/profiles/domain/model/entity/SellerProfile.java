package com.techshop.nanonerdsbackend.profiles.domain.model.entity;

import com.techshop.nanonerdsbackend.administration.domain.model.aggregates.Component;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.StreetAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class SellerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private Long ruc;

    @Setter
    @Getter
    private String nameCompany;

    @Embedded
    @Getter
    private StreetAddress address; //Columna street, number, city, zipcode y country

    @OneToMany(mappedBy = "sellerProfile", cascade =  CascadeType.ALL)
    @Getter
    private List<Component> components;

    public SellerProfile() {
        this.ruc = null;
        this.nameCompany = null;
        this.address = null;
    }

    public SellerProfile(Long ruc, String nameCompany, StreetAddress address) {
        this.ruc = ruc;
        this.nameCompany = nameCompany;
        this.address = address;
    }

    public void updateInformation(Long newRuc, String newNameCompany, StreetAddress newAddress){

        if (newRuc != null) {
            this.ruc = newRuc;
        }
        if (newNameCompany != null) {
            this.nameCompany = newNameCompany;
        }
        if (newAddress != null) {
            this.address = newAddress;
        }
    }


}