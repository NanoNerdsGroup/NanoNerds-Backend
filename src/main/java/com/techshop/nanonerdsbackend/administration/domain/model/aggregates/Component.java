    package com.techshop.nanonerdsbackend.administration.domain.model.aggregates;

    import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;
    import com.techshop.nanonerdsbackend.share.domain.model.entities.AuditableModel;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.Date;

    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
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

        @ManyToOne
        @JoinColumn(name = "seller_profile_id")
        private SellerProfile sellerProfile;


    }
