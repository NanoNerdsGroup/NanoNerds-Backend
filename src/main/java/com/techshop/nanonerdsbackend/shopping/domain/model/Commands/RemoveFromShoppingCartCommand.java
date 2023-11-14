package com.techshop.nanonerdsbackend.shopping.domain.model.Commands;



public record RemoveFromShoppingCartCommand(Long userId,Long itemId) {
}
