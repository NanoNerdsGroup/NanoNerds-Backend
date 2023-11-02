package com.techshop.nanonerdsbackend.profiles.domain.model.entity;
import com.techshop.nanonerdsbackend.profiles.domain.model.aggregates.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
@Getter
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subscriptionType;
    private String benefits;
    private float price;
    private Date purchasedAt;
    private Date expiresAt;


    public Subscription() {

    }

    public Subscription(String subscriptionType, String benefits, float price, Date purchasedAt, Date expiresAt) {
        this.subscriptionType = subscriptionType;
        this.benefits = benefits;
        this.price = price;
        this.purchasedAt = purchasedAt;
        this.expiresAt = expiresAt;
    }


    public LocalDate getStartDate() {
        return LocalDate.ofInstant(purchasedAt.toInstant(), ZoneId.systemDefault());
    }

    public LocalDate getEndDate() {
        return LocalDate.ofInstant(expiresAt.toInstant(), ZoneId.systemDefault());
    }

    public long getDurationInDays(){
        LocalDate startDate = getStartDate();
        LocalDate endDate = getEndDate();
        return java.time.Duration.between(startDate, endDate).toDays();

    }



}
