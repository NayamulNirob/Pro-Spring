package org.neyamul.ecomarceproject.repository;

import org.neyamul.ecomarceproject.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
    @Query("SELECT ci FROM CartItems ci WHERE ci.cart.cartId= ?1 AND ci.product.productId=?2")
    CartItems findCartItemsByProductIdAndCartId(Long cartId, Long productId);

    @Modifying
    @Query("DELETE FROM CartItems ci WHERE ci.cart.cartId = ?1 AND ci.product.productId = ?2")
    void deleteCartItemByProductIdAndCartId(Long cartId, Long productId);
}
