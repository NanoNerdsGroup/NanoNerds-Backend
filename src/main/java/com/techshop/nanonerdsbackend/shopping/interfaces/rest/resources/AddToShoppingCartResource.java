package com.techshop.nanonerdsbackend.shopping.interfaces.rest.resources;

public record AddToShoppingCartResource(  Long userId,Long componentId, int quantity) {
}
