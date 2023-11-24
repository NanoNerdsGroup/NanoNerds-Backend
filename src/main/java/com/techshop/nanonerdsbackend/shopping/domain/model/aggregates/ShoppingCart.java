package com.techshop.nanonerdsbackend.shopping.domain.model.aggregates;

import com.techshop.nanonerdsbackend.shopping.domain.model.entity.ShoppingCartItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShoppingCartItem> items = new ArrayList<>();

    public ShoppingCart() {
    }

    public ShoppingCart(Long userId) {
        this.userId = userId;
    }

    public void addItem(ShoppingCartItem item) {
        items.add(item);
    }

    public void removeItemById(Long componentId) {
        items.removeIf(item -> item.getId().equals(componentId));
    }

    public Optional<ShoppingCartItem> findItemById(Long componentId) {
        return items.stream()
                .filter(item -> item.getId().equals(componentId))
                .findFirst();
    }
}
