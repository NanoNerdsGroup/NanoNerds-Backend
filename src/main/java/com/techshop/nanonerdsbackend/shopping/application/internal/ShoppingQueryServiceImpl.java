package com.techshop.nanonerdsbackend.shopping.application.internal;

import com.techshop.nanonerdsbackend.shopping.domain.model.queries.ShoppingCartQuery;
import com.techshop.nanonerdsbackend.shopping.domain.services.ShoppingQueryService;

public class ShoppingQueryServiceImpl implements ShoppingQueryService {
    @Override
    public double getTotal(ShoppingCartQuery query) {
        return 0;
    }
}
