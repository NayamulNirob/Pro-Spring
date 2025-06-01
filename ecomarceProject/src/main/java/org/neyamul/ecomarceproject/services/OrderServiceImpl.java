package org.neyamul.ecomarceproject.services;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.neyamul.ecomarceproject.model.Cart;
import org.neyamul.ecomarceproject.payload.OrderDTO;
import org.neyamul.ecomarceproject.repository.AddressRepository;
import org.neyamul.ecomarceproject.repository.CartRepository;
import org.neyamul.ecomarceproject.repository.OrderItemRepository;
import org.neyamul.ecomarceproject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CartService cartService;

    @Autowired
    ModelMapper modelMapper;


    @Override
    @Transactional
    public OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage) {
        Cart cart =cartRepository.findCartByEmail(emailId);
        return null;
    }
}
