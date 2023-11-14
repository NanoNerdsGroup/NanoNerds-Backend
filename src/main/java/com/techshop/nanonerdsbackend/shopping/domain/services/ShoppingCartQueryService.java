package com.techshop.nanonerdsbackend.shopping.domain.services;

import com.techshop.nanonerdsbackend.shopping.domain.model.queries.ShoppingCartQuery;

public interface ShoppingCartQueryService {

    double getTotal(ShoppingCartQuery query);
}
