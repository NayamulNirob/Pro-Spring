package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.payload.CartDTO;

public interface CartService {

    CartDTO addProductToCart(Long productId, Integer quantity);
}
