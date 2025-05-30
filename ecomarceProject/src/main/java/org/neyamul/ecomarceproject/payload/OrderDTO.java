package org.neyamul.ecomarceproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long orderId;
    private String email;
    private List<OrderItemDTO> orderItems; // Assuming OrderItemDTO is defined elsewhere
    private LocalDate orderDate;
    private Double totalAmount;
    private String orderStatus;
    private Long addressId;
    private PaymentDTO payment; // Assuming PaymentDTO is defined elsewhere

}
