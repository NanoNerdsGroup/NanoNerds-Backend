package com.techshop.nanonerdsbackend.profiles.domain.model.entity;

import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.EmailAddress;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PersonName;
import com.techshop.nanonerdsbackend.profiles.domain.model.valueobjects.PhoneNumber;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
public class CustomerProfile {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    private PersonName name; //Columna Firstname y Lastname

    @Getter
    @Embedded
    private EmailAddress email; // Columna email

    @Getter
    @Embedded
    private PhoneNumber phone; // Columna codeCountry y PhoneNumber

    @Getter
    private String password;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;

    public CustomerProfile(){
        this.name = null;
        this.email = null;
        this.phone = null;
        this.password = null;
    }

    public CustomerProfile(PersonName name, EmailAddress email, PhoneNumber phone, String password){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    public void updateContactInformation(PersonName newName, EmailAddress newEmail, PhoneNumber newPhone, String newPassword) {
        if (newName != null) {
            this.name = newName;
        }
        if (newEmail != null) {
            this.email = newEmail;
        }
        if (newPhone != null) {
            this.phone = newPhone;
        }
        if (newPassword != null) {
            this.password = newPassword;
        }
    }


}
