package com.nayamul.product_practice.restcontroller;

import com.nayamul.product_practice.entity.Product;
import com.nayamul.product_practice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ProductRestController {

    final ProductService productService;

    @GetMapping("/get")
    public List<Product> get() {
        return productService.findAll();
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id ){
        return productService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id,Product product) {
         productService.delete(product,id);
    }

    @PutMapping("update/{id}")
    public Product update(@RequestBody Product product,@PathVariable Long id) {
        return productService.update(product,id);
    }
}
