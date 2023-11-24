package com.techshop.nanonerdsbackend.shopping.domain.model.entity;


import com.techshop.nanonerdsbackend.searchcomponents.domain.model.entities.Component;
import com.techshop.nanonerdsbackend.shopping.domain.model.aggregates.ShoppingCart;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")  // Asegúrate de usar el nombre correcto de la columna
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "componentId")
    private Component component;

    private int quantity;

    public ShoppingCartItem() {}

    public ShoppingCartItem(Component component, int quantity) {
        this.component = component;
        this.quantity = quantity;
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
