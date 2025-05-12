package org.neyamul.ecomarceproject.services;


import org.neyamul.ecomarceproject.model.Product;
import org.neyamul.ecomarceproject.payload.ProductDTO;

public interface ProductService {
    ProductDTO createProduct(Product product, Long categoryId);
}
