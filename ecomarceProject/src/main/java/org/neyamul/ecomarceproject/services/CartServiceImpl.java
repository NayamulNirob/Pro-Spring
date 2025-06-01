package org.neyamul.ecomarceproject.services;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.neyamul.ecomarceproject.exceptions.APIException;
import org.neyamul.ecomarceproject.exceptions.ResourceNoTFoundException;
import org.neyamul.ecomarceproject.model.Cart;
import org.neyamul.ecomarceproject.model.CartItems;
import org.neyamul.ecomarceproject.model.Product;
import org.neyamul.ecomarceproject.payload.CartDTO;
import org.neyamul.ecomarceproject.payload.ProductDTO;
import org.neyamul.ecomarceproject.repository.CartItemsRepository;
import org.neyamul.ecomarceproject.repository.CartRepository;
import org.neyamul.ecomarceproject.repository.ProductRepository;
import org.neyamul.ecomarceproject.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartItemsRepository cartItemsRepository;

    @Override
    public CartDTO addProductToCart(Long productId, Integer quantity) {

        Cart cart=createCart();

        Product product= productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNoTFoundException("Product","ProductId", productId)
        );
        CartItems cartItems =cartItemsRepository.findCartItemsByProductIdAndCartId(cart.getCartId(), productId);

        if(cartItems!=null){
            throw new APIException("Product"+product.getProductName() + "Already Exists in the cart");
        }
        if(product.getQuantity()==0){
            throw new APIException(product.getProductName()+"Is not Available");
        }
        if (product.getQuantity()< quantity){
            throw new APIException("Please make an order of the"
                    +product.getProductName()
                    +"Less then or Equal of quantity"
                    +product.getQuantity()+ ".");
        }
        CartItems newCartItems= new CartItems();
        newCartItems.setProduct(product);
        newCartItems.setCart(cart);
        newCartItems.setQuantity(quantity);
        newCartItems.setDiscount(product.getDiscount());
        newCartItems.setProductPrice(product.getSpecialPrice());

        cartItemsRepository.save(newCartItems);

//        product.setQuantity(product.getQuantity()-quantity);

        product.setQuantity(product.getQuantity());

        cart.setTotalPrice(cart.getTotalPrice()+(product.getSpecialPrice()*quantity));

        cartRepository.save(cart);

        CartDTO cartDTO=modelMapper.map(cart,CartDTO.class);

        List<CartItems> cartItem=cart.getCartItems();



     Stream<ProductDTO> productDTOStream = cartItem.stream().map(
         item -> {
             ProductDTO map = modelMapper.map(item.getProduct(), ProductDTO.class);
             map.setQuantity(item.getQuantity());
             return map;
         }
     );

        cartDTO.setProducts(productDTOStream.toList());
        List<ProductDTO> products = cart.getCartItems().stream()
                .map(p -> modelMapper.map(p.getProduct(), ProductDTO.class)).toList();

        cart.getCartItems().forEach(c ->
                c.getProduct().setQuantity(c.getQuantity()));

        cartDTO.setProducts(products);
        return cartDTO;
    }

    private Cart createCart(){
        Cart userCart= cartRepository.findCartByEmail(authUtil.loggedInEmail());
        if (userCart!=null){
            return userCart;
        }
        Cart cart=new Cart();
        cart.setTotalPrice(0.00);
        cart.setUser(authUtil.loggedInUser());
        return cartRepository.save(cart);
    }

    @Override
    public List<CartDTO> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();

        if (carts.size() == 0) {
            throw new APIException("No cart exists");
        }

        List<CartDTO> cartDTOs = carts.stream().map(cart -> {
            CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);

            List<ProductDTO> products = cart.getCartItems().stream().map(cartItem -> {
                ProductDTO productDTO = modelMapper.map(cartItem.getProduct(), ProductDTO.class);
                productDTO.setQuantity(cartItem.getQuantity()); // Set the quantity from CartItem
                return productDTO;
            }).collect(Collectors.toList());


            cartDTO.setProducts(products);

            return cartDTO;

        }).collect(Collectors.toList());

        return cartDTOs;
    }

    @Override
    public CartDTO getCart(String emailId, Long cartId) {
        Cart cart = cartRepository.findCartByEmailAndCartId(emailId,cartId);
        if (cart == null) {
            throw new ResourceNoTFoundException("Cart", "CartId", cartId);
        }
        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);

        cart.getCartItems().forEach(c ->
                c.getProduct().setQuantity(c.getQuantity()));

        List<ProductDTO> products = cart.getCartItems().stream()
                .map(p -> modelMapper.map(p.getProduct(), ProductDTO.class)).toList();
        cartDTO.setProducts(products);
        return cartDTO;
    }

    @Transactional
    @Override
    public CartDTO updateProductQuantityInCart(Long productId, Integer quantity) {

        String emailId = authUtil.loggedInEmail();
        Cart userCart = cartRepository.findCartByEmail(emailId);
        Long cartId  = userCart.getCartId();

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNoTFoundException("Cart", "cartId", cartId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNoTFoundException("Product", "productId", productId));

        if (product.getQuantity() == 0) {
            throw new APIException(product.getProductName() + " is not available");
        }

        if (product.getQuantity() < quantity) {
            throw new APIException("Please, make an order of the " + product.getProductName()
                    + " less than or equal to the quantity " + product.getQuantity() + ".");
        }

        CartItems cartItem = cartItemsRepository.findCartItemsByProductIdAndCartId(cartId, productId);

        if (cartItem == null) {
            throw new APIException("Product " + product.getProductName() + " not available in the cart!!!");
        }

        // Calculate new quantity
        int newQuantity = cartItem.getQuantity() + quantity;

        // Validation to prevent negative quantities
        if (newQuantity < 0) {
            throw new APIException("The resulting quantity cannot be negative.");
        }

        if (newQuantity == 0){
            deleteProductFromCart(cartId, productId);
        } else {
            cartItem.setProductPrice(product.getSpecialPrice());
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.setDiscount(product.getDiscount());
            cart.setTotalPrice(cart.getTotalPrice() + (cartItem.getProductPrice() * quantity));
            cartRepository.save(cart);
        }

        CartItems updatedItem = cartItemsRepository.save(cartItem);
        if(updatedItem.getQuantity() == 0){
            cartItemsRepository.deleteById(updatedItem.getCartItemId());
        }


        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);

        List<CartItems> cartItems = cart.getCartItems();

        Stream<ProductDTO> productStream = cartItems.stream().map(item -> {
            ProductDTO prd = modelMapper.map(item.getProduct(), ProductDTO.class);
            prd.setQuantity(item.getQuantity());
            return prd;
        });


        cartDTO.setProducts(productStream.toList());

        return cartDTO;
    }

    @Transactional
    @Override
    public String deleteProductFromCart(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNoTFoundException("Cart", "cartId", cartId));

        CartItems cartItem = cartItemsRepository.findCartItemsByProductIdAndCartId(cartId, productId);

        if (cartItem == null) {
            throw new ResourceNoTFoundException("Product", "productId", productId);
        }

        cart.setTotalPrice(cart.getTotalPrice() -
                (cartItem.getProductPrice() * cartItem.getQuantity()));

        cartItemsRepository.deleteCartItemByProductIdAndCartId(cartId, productId);

        return "Product " + cartItem.getProduct().getProductName() + " removed from the cart !!!";
    }

    @Override
    public void updateProductInCarts(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNoTFoundException("Cart", "cartId", cartId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNoTFoundException("Product", "productId", productId));

        CartItems cartItem = cartItemsRepository.findCartItemsByProductIdAndCartId(cartId, productId);

        if (cartItem == null) {
            throw new APIException("Product " + product.getProductName() + " not available in the cart!!!");
        }

        double cartPrice = cart.getTotalPrice()
                - (cartItem.getProductPrice() * cartItem.getQuantity());

        cartItem.setProductPrice(product.getSpecialPrice());

        cart.setTotalPrice(cartPrice
                + (cartItem.getProductPrice() * cartItem.getQuantity()));

        cartItem = cartItemsRepository.save(cartItem);
    }


}