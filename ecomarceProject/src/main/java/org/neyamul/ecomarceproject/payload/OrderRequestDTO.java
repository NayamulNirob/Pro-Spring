package org.neyamul.ecomarceproject.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private Long addressId;
    private String paymentMethod; // e.g., "Credit Card", "PayPal"
    private String pgName; // Name of the payment gateway e.g., "Stripe", "PayPal"
    private String pgPaymentId; // e.g., "Completed", "Pending"
    private String pgStatus; // e.g., "succeeded", "pending"
    private String pgResponseMessage; // JSON response from the payment gateway
}
