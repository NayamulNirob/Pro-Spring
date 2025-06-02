package org.neyamul.ecomarceproject.services;

import jakarta.transaction.Transactional;
import org.neyamul.ecomarceproject.payload.OrderDTO;

public interface OrderService {

    @Transactional
    OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage);
}
