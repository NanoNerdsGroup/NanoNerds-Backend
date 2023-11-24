

package com.techshop.nanonerdsbackend.shopping.interfaces.rest;

import com.techshop.nanonerdsbackend.shopping.domain.services.ShoppingCommandService;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.AddCreditCardResource;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.AddToShoppingCartResource;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.RemoveFromShoppingCartResource;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.transform.AddCreditCardCommandFromResourceAssembler;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.transform.AddToShoppingCartCommandFromResourceAssembler;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.transform.RemoveFromShoppingCartCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/shopping-cart", produces = MediaType.APPLICATION_JSON_VALUE)

public class ShoppingController {

    private final ShoppingCommandService shoppingCommandService;


    public ShoppingController(ShoppingCommandService shoppingCommandService) {

        this.shoppingCommandService = shoppingCommandService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToShopping(@RequestBody AddToShoppingCartResource resource) {
        var addShoppingCartCommand = AddToShoppingCartCommandFromResourceAssembler.toCommandFromResource(resource);
        shoppingCommandService.addToShoppingCart(addShoppingCartCommand);
        return ResponseEntity.ok("Componente agregado al carrito exitosamente");
    }


    @PostMapping("/remove")
    public ResponseEntity<String> removeFromShoppingCart(@RequestBody RemoveFromShoppingCartResource resource) {
        try {
            var removeFromShoppingCartCommand = RemoveFromShoppingCartCommandFromResourceAssembler.toCommandFromResource(resource);
            shoppingCommandService.removeFromShoppingCart(removeFromShoppingCartCommand);
            return ResponseEntity.ok("Componente eliminado del carrito exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el componente del carrito: " + e.getMessage());
        }
    }

    @PostMapping("/add-credit-card")
    public ResponseEntity<String> addCreditCard(@RequestBody AddCreditCardResource resource) {
        try {
            var addCreditCardCommand = AddCreditCardCommandFromResourceAssembler.toCommandFromResource(resource);
            shoppingCommandService.addCreditCard(addCreditCardCommand);
            return ResponseEntity.ok("Tarjeta de crédito agregada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al agregar la tarjeta de crédito: " + e.getMessage());
        }
    }

}

