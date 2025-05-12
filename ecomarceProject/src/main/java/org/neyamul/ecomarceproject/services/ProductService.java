package org.neyamul.ecomarceproject.services;


import org.neyamul.ecomarceproject.model.Product;
import org.neyamul.ecomarceproject.payload.ProductDTO;
import org.neyamul.ecomarceproject.payload.ProductResponse;

public interface ProductService {
    ProductDTO createProduct(Product product, Long categoryId);

    ProductResponse getAllProducts();
}
