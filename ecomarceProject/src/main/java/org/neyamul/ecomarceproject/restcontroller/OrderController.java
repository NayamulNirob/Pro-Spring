package org.neyamul.ecomarceproject.restcontroller;

import jakarta.validation.Valid;
import org.neyamul.ecomarceproject.payload.OrderDTO;
import org.neyamul.ecomarceproject.payload.OrderRequestDTO;
import org.neyamul.ecomarceproject.services.OrderService;
import org.neyamul.ecomarceproject.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private OrderService orderService;


    @PostMapping("/orders/users/payments/{paymentMethod}")
    public ResponseEntity<OrderDTO>orderProducts(@Valid @PathVariable String paymentMethod, @RequestBody OrderRequestDTO orderRequestDTO){
        String emailId=authUtil.loggedInEmail();
        OrderDTO orderDTO= orderService.placeOrder(
                emailId,
                orderRequestDTO.getAddressId(),
                paymentMethod,
                orderRequestDTO.getPgName(),
                orderRequestDTO.getPgPaymentId(),
                orderRequestDTO.getPgStatus(),
                orderRequestDTO.getPgResponseMessage()

        );
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }



}
