package org.neyamul.ecomarceproject.repository;

import org.neyamul.ecomarceproject.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
}
