package org.neyamul.ecomarceproject.services;

import org.modelmapper.ModelMapper;
import org.neyamul.ecomarceproject.exceptions.ResourceNoTFoundException;
import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.model.Product;
import org.neyamul.ecomarceproject.payload.ProductDTO;
import org.neyamul.ecomarceproject.payload.ProductResponse;
import org.neyamul.ecomarceproject.repository.CategoryRepository;
import org.neyamul.ecomarceproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FileService fileService;

    @Value("${file.upload.path}")
    private String path;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNoTFoundException("Category", "categoryId", categoryId));

        Product product = modelMapper.map(productDTO, Product.class);
        product.setCategory(category);
        product.setSpecialPrice( product.getPrice()-(product.getDiscount()*0.01)*product.getPrice());
        product.setImage("default.png");
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductContent(productDTOS);
        return productResponse;
    }

    @Override
    public ProductResponse searchByCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNoTFoundException("Category", "categoryId", categoryId));
        List<Product> products = productRepository.findByCategoryOrderByPriceAsc(category);
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductContent(productDTOS);
        return productResponse;
    }

    @Override
    public ProductResponse findProductNameLikeIgnoreCase(String keyword) {
        List<Product> products = productRepository.findByProductNameLikeIgnoreCase('%'+keyword+'%');
        if (products.isEmpty()) {
            throw new ResourceNoTFoundException("Product", "productName", keyword);
        }
        List<ProductDTO> productDTOS = products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductContent(productDTOS);
        return productResponse;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNoTFoundException("Product", "productId", productId));

        Product product = modelMapper.map(productDTO, Product.class);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setSpecialPrice(product.getPrice()-(product.getDiscount()*0.01)*product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setQuantity(product.getQuantity());

        productRepository.save(existingProduct);

        return modelMapper.map(existingProduct, ProductDTO.class);

    }

    @Override
    public ProductDTO deleteProduct(Long productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNoTFoundException("Product", "productId", productId));
        productRepository.delete(existingProduct);
        return modelMapper.map(existingProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProductImage(MultipartFile image, Long productId) throws IOException {
        Product productFromDB = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNoTFoundException("Product", "productId", productId));
        String fileName = fileService.uploadImage(path,image);
        productFromDB.setImage(fileName);
        Product updatedProduct = productRepository.save(productFromDB);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }


}
