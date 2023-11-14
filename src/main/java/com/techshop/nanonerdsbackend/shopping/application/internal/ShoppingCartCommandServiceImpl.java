package com.techshop.nanonerdsbackend.shopping.application.internal;

import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.AddToShoppingCartCommand;
import com.techshop.nanonerdsbackend.shopping.domain.model.Commands.RemoveFromShoppingCartCommand;
import com.techshop.nanonerdsbackend.shopping.domain.model.aggregates.ShoppingCart;
import com.techshop.nanonerdsbackend.shopping.domain.model.entity.ShoppingCartItem;
import com.techshop.nanonerdsbackend.shopping.domain.services.ShoppingCartCommandService;
import com.techshop.nanonerdsbackend.shopping.infraestructure.persistence.jpa.repositories.ComponentRepository;
import com.techshop.nanonerdsbackend.shopping.infraestructure.persistence.jpa.repositories.ShoppingCartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartCommandServiceImpl implements ShoppingCartCommandService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ComponentRepository componentRepository;

    public ShoppingCartCommandServiceImpl(ShoppingCartRepository shoppingCartRepository, ComponentRepository componentRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.componentRepository = componentRepository;
    }

    @Override
    public void addToShoppingCart(AddToShoppingCartCommand command) {
     ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(command.userId())
             .orElseGet(() -> new ShoppingCart(command.userId()));

     ShoppingCartItem newItem = new ShoppingCartItem(componentRepository.findById(command.componentId()).orElseThrow(),
             command.quantity());

        Optional<ShoppingCartItem> existingItem =shoppingCart.findItemById(command.componentId());
        if (existingItem.isPresent()) {
            existingItem.get().updateQuantity(command.quantity());
        } else {
            shoppingCart.addItem(newItem);
        }
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void removeFromShoppingCart(RemoveFromShoppingCartCommand command) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(command.userId())
                .orElseThrow(() -> new EntityNotFoundException("Shopping cart not found for user " + command.userId()));

        shoppingCart.removeItemById(command.itemId());
        shoppingCartRepository.save(shoppingCart);

    }
}