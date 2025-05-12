package org.neyamul.ecomarceproject.restcontroller;

import org.neyamul.ecomarceproject.model.Product;
import org.neyamul.ecomarceproject.payload.ProductDTO;
import org.neyamul.ecomarceproject.payload.ProductResponse;
import org.neyamul.ecomarceproject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @PostMapping("admin/category/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(
            @RequestBody Product product,
            @PathVariable Long categoryId
    ) {
        ProductDTO productDTO= productService.createProduct(product, categoryId);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @GetMapping("public/products")
    public ResponseEntity<ProductResponse> getAllProducts() {
       ProductResponse productResponse= productService.getAllProducts();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

}
