package com.techshop.nanonerdsbackend.profiles.domain.model.aggregates;

import com.techshop.nanonerdsbackend.profiles.domain.model.entity.CustomerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.SellerProfile;
import com.techshop.nanonerdsbackend.profiles.domain.model.entity.Subscription;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.EmailAddress;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PersonName;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PhoneNumber;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.SuscriptionPack;
import com.techshop.nanonerdsbackend.share.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Entity
public class User  extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @OneToOne
    @JoinColumn(name = "customer_id")
    private  CustomerProfile customerProfile;

    @Getter
    @OneToOne
    @JoinColumn(name = "seller_id")
    private SellerProfile sellerProfile;

    @Getter
    @Embedded
    private SuscriptionPack subscriptionPack;


    public User(){

    }
    public User(String firstName, String lastname, String email, String password, String codeCountry, String phoneNumber) {
        this.customerProfile = new CustomerProfile(
                new PersonName(firstName, lastname),
                new EmailAddress(email),
                new PhoneNumber(codeCountry,phoneNumber),
                password
        );
    }

    public User(CustomerProfile customerProfile) {
        this.customerProfile=customerProfile;
    }

    public boolean validateSellerFunctions(){
        if(this.sellerProfile==null || this.sellerProfile.getRuc() == 0){
            throw new IllegalArgumentException("You can't use seller functions because you need " +
                    "to give informations about the company");
        }
        else{
            return true;
        }
    }

    public boolean updateUserInformation(CustomerProfile customer, SellerProfile seller){
        if (customer != null) {
            this.customerProfile.updateContactInformation(customer.getName(), customer.getEmail(),
                                                          customer.getPhone(), customer.getPassword());
            return true;
        }
        else if (seller != null){
            this.sellerProfile.updateInformation(seller.getRuc(), seller.getNameCompany(), seller.getAddress());
            return true;
        }
        return false;
    }




}
