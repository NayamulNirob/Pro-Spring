package org.neyamul.ecomarceproject.services;

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
        if (product.getQuantity()<= quantity){
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

        product.setQuantity(product.getQuantity());
        cart.setTotalPrice(cart.getTotalPrice()+(product.getSpecialPrice()*quantity));
        cartRepository.save(cart);

        CartDTO cartDTO=modelMapper.map(cart,CartDTO.class);

        List<CartItems> cartItem=cart.getCartItems();

        Stream <ProductDTO> productDTOStream=cartItem.stream().map(
                item->{
                    ProductDTO map= modelMapper.map(item.getProduct(),ProductDTO.class);
                    map.setQuantity(item.getQuantity());
                    return map;
                });

        cartDTO.setProducts(productDTOStream.toList());

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
        Cart newCart= cartRepository.save(cart);
        return newCart;
    }
}
