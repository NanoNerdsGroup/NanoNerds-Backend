    package com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities;

    import com.techshop.nanonerdsbackend.share.domain.model.entities.AuditableModel;
    import jakarta.persistence.*;
    import lombok.Getter;

    import java.util.Date;

    @Getter
    @Entity
    public class Component extends AuditableModel {

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

        public Component(){}

        public Component(double price, String description, Date date, String manufacturer, String compatibility, String type, int amount) {
            this.price = price;
            this.description = description;
            this.date = date;
            this.manufacturer = manufacturer;
            this.compatibility = compatibility;
            this.type = type;
            this.amount = amount;
        }

    }
