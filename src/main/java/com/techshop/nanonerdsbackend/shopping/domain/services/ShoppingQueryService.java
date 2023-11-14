package com.techshop.nanonerdsbackend.shopping.domain.services;

import com.techshop.nanonerdsbackend.shopping.domain.model.queries.ShoppingCartQuery;

public interface ShoppingQueryService {

    double getTotal(ShoppingCartQuery query);
}
