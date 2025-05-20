package org.neyamul.ecomarceproject.repository;

import org.neyamul.ecomarceproject.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
