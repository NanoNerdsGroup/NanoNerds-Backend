package com.techshop.nanonerdsbackend.shopping.domain.model.Commands;




public record AddToShoppingCartCommand(
        Long userId,
        Long componentId,
        int quantity) {

}