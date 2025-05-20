package org.neyamul.ecomarceproject.restcontroller;

import org.neyamul.ecomarceproject.payload.CartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @PostMapping("/products/{productId}/quantity/{quantity}")
    public ResponseEntity<CartDTO> addProductToCart(@PathVariable Long productId,
                                                    @PathVariable Integer quantity) {

        return ResponseEntity.ok(new CartDTO());
    }

}
