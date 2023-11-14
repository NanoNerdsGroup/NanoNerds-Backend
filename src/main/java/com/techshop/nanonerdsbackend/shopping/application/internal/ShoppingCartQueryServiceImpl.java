package com.techshop.nanonerdsbackend.shopping.application.internal;

import com.techshop.nanonerdsbackend.shopping.domain.model.queries.ShoppingCartQuery;
import com.techshop.nanonerdsbackend.shopping.domain.services.ShoppingCartQueryService;

public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService {
    @Override
    public double getTotal(ShoppingCartQuery query) {
        return 0;
    }
}
