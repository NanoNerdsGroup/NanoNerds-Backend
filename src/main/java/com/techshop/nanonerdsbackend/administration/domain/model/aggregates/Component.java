    package com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities;

    import com.techshop.nanonerdsbackend.share.domain.model.entities.AuditableModel;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;

    import java.util.Date;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Entity
    public class Component {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Basic
        private double price;
        private String name;
        private String description;
        private Date date;
        private String manufacturer;
        private String compatibility;
        private String type;
        private double amount;
        private String software;

    }
