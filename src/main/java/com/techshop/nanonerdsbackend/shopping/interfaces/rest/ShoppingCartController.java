package com.techshop.nanonerdsbackend.shopping.interfaces.rest;


import com.techshop.nanonerdsbackend.shopping.domain.model.aggregates.ShoppingCart;
import com.techshop.nanonerdsbackend.shopping.domain.services.ShoppingCartCommandService;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.AddToShoppingCartResource;
import com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources.RemoveFromShoppingCartResource;
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

public class ShoppingCartController {

    private final ShoppingCartCommandService shoppingCartCommandService;


    public ShoppingCartController(ShoppingCartCommandService shoppingCartCommandService) {

        this.shoppingCartCommandService = shoppingCartCommandService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToShopping(@RequestBody AddToShoppingCartResource resource) {
        var addShoppingCartCommand = AddToShoppingCartCommandFromResourceAssembler.toCommandFromResource(resource);
        shoppingCartCommandService.addToShoppingCart(addShoppingCartCommand);
        return ResponseEntity.ok("Componente agregado al carrito exitosamente");
    }


    @PostMapping("/remove")
    public ResponseEntity<String> removeFromShoppingCart(@RequestBody RemoveFromShoppingCartResource resource) {
        try {
            var removeFromShoppingCartCommand = RemoveFromShoppingCartCommandFromResourceAssembler.toCommandFromResource(resource);
            shoppingCartCommandService.removeFromShoppingCart(removeFromShoppingCartCommand);
            return ResponseEntity.ok("Componente eliminado del carrito exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al eliminar el componente del carrito: " + e.getMessage());
        }
    }
}

